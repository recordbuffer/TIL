from sqlalchemy import Column, Integer, VARCHAR, DateTime
from datetime import datetime

from database import Base

class Board(Base):
  __tablename__="Board"
  
  no = Column(Integer, primary_key=True, autoincrement=True)
  writer = Column(VARCHAR(30), nullable=False)
  title = Column(VARCHAR(30), nullable=False)
  content = Column(VARCHAR(100), nullable=False)
  date = Column(DateTime, nullable=False, default=datetime.now)
  del_yn = Column(VARCHAR(1), nullable=False, default='Y')


class User(Base):
  __tablename__ = "Users"
  
  user_no = Column(Integer, primary_key=True, autoincrement=True)
  user_name = Column(VARCHAR(10), nullable=True)
  email= Column(VARCHAR(100), nullable=False)
  hashed_pw=Column(VARCHAR(100), nullable=True)
  role=Column(VARCHAR(20), nullable=False, default='MEMBER')
  status=Column(VARCHAR(1), nullable=False, default='1')
  regdate = Column(DateTime, nullable=False, default=datetime.now)
  provider = Column(VARCHAR(20), nullable=True)