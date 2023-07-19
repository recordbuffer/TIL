from sqlalchemy.orm import Session

from models import Board
from board import board_crud, board_schema

def insert_post(new_post: board_schema.NewPost, db: Session):
    post = Board(
        writer = new_post.writer,
        title = new_post.title,
        content = new_post.content
    ) 
    db.add(post)
    db.commit