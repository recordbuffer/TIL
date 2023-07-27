from sqlalchemy.orm import Session

from models import Board
from board.board_schema import NewPost, PostList

def insert_post(new_post: NewPost, db: Session):
    post = Board(
        writer = new_post.writer,
        title = new_post.title,
        content = new_post.content
    ) 
    db.add(post)
    db.commit


def list_all_post(db: Session):
  lists = db.query(Board).filter(Board.del_yn == 'Y').all()
  print(PostList.__class__)
  print(lists.__class__)
  return lists