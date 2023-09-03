
from sqlalchemy.orm import Session
from database import get_db

from datetime import datetime
from datetime import timedelta
from jose import jwt

from fastapi import APIRouter, Depends, status, HTTPException
from fastapi.security import OAuth2PasswordRequestForm

from user import user_schema, user_crud

import os
from dotenv import load_dotenv

load_dotenv()
SECRET_KEY = os.getenv("SECRET_KEY")
ALGORITHM = os.getenv("ALGORITHM")
ACCESS_TOKEN_EXPIRE_MINUTES = os.getenv("ACCESS_TOKEN_EXPIRE_MINUTES")

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
    user = user_crud.get_user(new_user.email, db)

    if user:
        raise HTTPException(status_code=status.HTTP_409_CONFLICT, detail="User already exists")

    # 회원 가입
    user_crud.create_user(new_user, db)

    return HTTPException(status_code=status.HTTP_200_OK, detail="Signup successful")


@app.post(path="/login")
async def login(login_form: OAuth2PasswordRequestForm = Depends(), db: Session = Depends(get_db)):
    # 회원 존재 여부 확인
    user = user_crud.get_user(login_form.username, db)

    if not user:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Invalid user or password")
    
    # 로그인
    res = user_crud.verify_password(login_form.password, user.hashed_pw)

    # 토큰 생성
    access_token_expires = timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    access_token = user_crud.create_access_token(data={"sub": user.username}, expires_delta=access_token_expires)

    if not res:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Invalid user or password")

    return HTTPException(status_code=status.HTTP_200_OK, detail="Login successful", access_token= {})