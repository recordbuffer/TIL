from enum import Enum
from typing import Optional, Union

from pydantic import BaseModel


class PROVIDER_ENUM(Enum):
    KAKAO = ('kakao')
    NAVER = ('naver')
    GOOGLE = ('google')

    def __init__(self, title):
        self.title = title

    @classmethod
    def from_str(cls, name: str):
        for enum in cls:
            if enum.value == name:
                return enum


class SocialLogin(BaseModel):
    code: str


class SocialMember(BaseModel):
    email: Optional[str]
    name: Optional[str] = None
    provider: Union[str, PROVIDER_ENUM]
