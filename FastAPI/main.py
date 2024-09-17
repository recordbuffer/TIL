from fastapi import FastAPI
from starlette.middleware.cors import CORSMiddleware

import models
from database import engine
from oauth import social_router

models.Base.metadata.create_all(bind=engine)

from board import board_router
from user import user_router

app = FastAPI()

app.include_router(board_router.app, tags=["board"])
app.include_router(user_router.app, tags=["user"])
app.include_router(social_router.app, tags=["oauth"])

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
def read_root():
    return {"Hello": "World"}