from fastapi import FastAPI

import models
from database import engine
models.Base.metadata.create_all(bind=engine)

from board import board_router
from user import user_router

app = FastAPI()

app.include_router(board_router.app, tags=["board"])
app.include_router(user_router.app, tags=["user"])


@app.get("/")
def read_root():
    return {"Hello": "World"}