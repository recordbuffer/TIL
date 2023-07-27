from sqlalchemy.orm import Session
from database import get_db

from fastapi import APIRouter, Depends

from board import board_crud, board_schema

app = APIRouter(
    prefix="/board",
)

@app.post(path="/create", description="기본 게시판 - 게시글 생성")
async def create_new_post(new_post: board_schema.NewPost, db: Session = Depends(get_db)):
  return board_crud.insert_post(new_post, db)


@app.get(path="/read", description="기본 게시판 - 게시글 조회")
async def read_all_post(db: Session = Depends(get_db)):
  return board_crud.list_all_post(db)