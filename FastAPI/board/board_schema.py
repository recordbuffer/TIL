from pydantic import BaseModel
from typing import Optional

class NewPost(BaseModel):
  writer: str
  title: str
  content: Optional[str] = None

