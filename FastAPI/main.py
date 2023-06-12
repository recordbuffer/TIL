from fastapi import FastAPI

from basic import basic_router

app = FastAPI()

app.include_router(basic_router.router, tags=["basic"])