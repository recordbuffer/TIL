from fastapi import APIRouter, HTTPException, Depends
from sqlalchemy.orm import Session
from starlette import status
from starlette.responses import JSONResponse

from database import get_db
from oauth import social_handler
from oauth.social_schema import SocialLogin, PROVIDER_ENUM
from user import user_crud

app = APIRouter(
    prefix="/oauth",
)

@app.post(path="/{provider}", description="소셜 로그인 / 회원가입")
async def social_auth(provider: str, form: SocialLogin, db: Session = Depends(get_db)):

    # provider에 따라 분기처리
    provider = PROVIDER_ENUM.from_str(provider.lower())
    if not provider:
        raise HTTPException(status_code=404)

    try:
        if provider == PROVIDER_ENUM.GOOGLE:
            user_data = social_handler.auth_google(form.code)
        elif provider == PROVIDER_ENUM.KAKAO:
            user_data = social_handler.auth_kakao(form.code)
        else:
            user_data = social_handler.auth_naver(form.code)

        user = user_crud.get_user(db, user_data.email, provider=user_data.provider)

        # 존재하는 회원시 로그인처리
        if user and user.status != '9':
            response_body = {"message": "oauth login successful", "name": user_data.email}
            return JSONResponse(status_code=status.HTTP_200_OK, content=response_body)
        else:
            # 존재하지 않는 회원시 회원가입처리
            user_crud.create_social_user(user_data, db)
            response_body = {"message": "oauth register successful", "name": user_data.email}
            return JSONResponse(status_code=status.HTTP_200_OK, content=response_body)

    except Exception as e:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail=str(e))
