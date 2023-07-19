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