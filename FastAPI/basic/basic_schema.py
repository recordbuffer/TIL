from pydantic import BaseModel

from enum import Enum


class Item(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None
    
    class Config:
        schema_extra = {
            "example": {
                "name": "Foo",
                "description": "A very nice Item",
                "price": 35.4,
                "tax": 3.2,
            }
        }

class ModelName(str, Enum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"