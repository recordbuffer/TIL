from fastapi import FastAPI

from basic import basic_router
from dependencies import depend_router

app = FastAPI()

app.include_router(basic_router.app, tags=["basic"])
app.include_router(basic_router.app, tags=["basic"])