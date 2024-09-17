
from sqlalchemy.orm import Session
from starlette.responses import JSONResponse

from database import get_db

from datetime import datetime
from datetime import timedelta
from jose import jwt

from fastapi import APIRouter, Depends, status, HTTPException, Response, Request
from fastapi.security import OAuth2PasswordRequestForm

from user import user_schema, user_crud

import os
from dotenv import load_dotenv

load_dotenv()
SECRET_KEY = os.getenv("SECRET_KEY")
ALGORITHM = os.getenv("ALGORITHM")
ACCESS_TOKEN_EXPIRE_MINUTES = float(os.getenv("ACCESS_TOKEN_EXPIRE_MINUTES"))

app = APIRouter(
  prefix="/user"
)

def create_access_token(data: dict, expires_delta: timedelta | None = None):
    to_encode = data.copy()
    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.utcnow() + timedelta(minutes=15)
    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt


@app.post(path="/signup")
async def signup(new_user: user_schema.NewUserForm, db: Session = Depends(get_db)):    
    # 회원 존재 여부 확인
    user = user_crud.get_user(db, new_user.email)

    if user:
        raise HTTPException(status_code=status.HTTP_409_CONFLICT, detail="User already exists")

    # 회원 가입
    user_crud.create_user(new_user, db)

    response_body = {"message": "Signup successful"}
    return JSONResponse(status_code=status.HTTP_200_OK, content=response_body)


@app.post(path="/login")
async def login(response: Response, login_form: OAuth2PasswordRequestForm = Depends(), db: Session = Depends(get_db)):
    # 회원 존재 여부 확인
    user = user_crud.get_user(db, login_form.username)

    if not user:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Invalid user or password")
    
    # 로그인
    res = user_crud.verify_password(login_form.password, user.hashed_pw)

    # 토큰 생성
    access_token_expires = timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    access_token = create_access_token(data={"sub": user.user_name}, expires_delta=access_token_expires)

    # 쿠키에 저장
    response.set_cookie(key="access_token", value=access_token, expires=access_token_expires, httponly=True)

    if not res:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Invalid user or password")

    response_body = user_schema.Token(access_token=access_token, token_type="bearer")
    return JSONResponse(status_code=status.HTTP_200_OK, content=response_body)


@app.get(path="/logout")
async def logout(response: Response, request: Request):
    access_token = request.cookies.get("access_token")

    # 쿠키 삭제
    response.delete_cookie(key="access_token")

    response_body = {"message": "Logout successful"}
    return JSONResponse(status_code=status.HTTP_200_OK, content=response_body)
