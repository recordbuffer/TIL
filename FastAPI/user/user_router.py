from sqlalchemy.orm import Session
from database import get_db

from fastapi import APIRouter, Depends, status, HTTPException

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
    else:
        user_crud.create_user(new_user, db)
    return {"message": "Signup successful"}