from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class NewPost(BaseModel):
  writer: str
  title: str
  content: Optional[str] = None


class PostList(BaseModel):
  no: int
  writer: str
  title: str
  date: datetime


class Post(BaseModel):
  no: int
  writer: str
  title: str
  content: Optional[str] = None
  date: datetime


class UpdatePost(BaseModel):
  no: int
  title: str
  content: Optional[str] = None