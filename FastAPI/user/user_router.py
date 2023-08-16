from sqlalchemy.orm import Session
from database import get_db

from fastapi import APIRouter, Depends, status, HTTPException
from fastapi.security import OAuth2PasswordRequestForm

from user import user_schema, user_crud

app = APIRouter(
  prefix="/user"
)


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

    if not res:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Invalid user or password")

    return HTTPException(status_code=status.HTTP_200_OK, detail="Login successful")