import os

import requests

from oauth.social_schema import SocialMember, PROVIDER_ENUM

GOOGLE_CLIENT_ID = os.getenv("GOOGLE_CLIENT_ID")
GOOGLE_CLIENT_SECRET = os.getenv("GOOGLE_SECRET")
GOOGLE_CALLBACK_URI = "http://127.0.0.1:5500/google/callback.html"

KAKAO_CLIENT_ID = os.getenv("KAKAO_CLIENT_ID")
KAKAO_SECRET = os.getenv("KAKAO_SECRET")
KAKAO_CALLBACK_URI = "http://127.0.0.1:5500/kakao/callback.html"

NAVER_CLIENT_ID = os.getenv("NAVER_CLIENT_ID")
NAVER_SECRET = os.getenv("NAVER_SECRET")
STATE = os.getenv("NAVER_STATE")


def auth_google(code: str):
    try:
        # google에 access token 요청
        token_url = f"https://oauth2.googleapis.com/token?client_id={GOOGLE_CLIENT_ID}&client_secret={GOOGLE_CLIENT_SECRET}&code={code}&grant_type=authorization_code&redirect_uri={GOOGLE_CALLBACK_URI}"
        token_response = requests.post(token_url)
        if token_response.status_code != 200:
            raise Exception

        # google에 회원 정보 요청
        access_token = token_response.json()['access_token']
        user_info = f"https://www.googleapis.com/oauth2/v1/userinfo?access_token={access_token}"
        user_response = requests.get(user_info)
        if user_response.status_code != 200:
            raise Exception
    except:
        raise Exception("google oauth error")

    info = user_response.json()
    return SocialMember(
        name=info.get('name'),
        email=info.get('email'),
        provider=PROVIDER_ENUM.GOOGLE.name
    )


def auth_kakao(code: str):
    try:
        # kakao에 access token 요청
        token_url = f"https://kauth.kakao.com/oauth/token?client_id={KAKAO_CLIENT_ID}&client_secret={KAKAO_SECRET}&code={code}&grant_type=authorization_code&redirect_uri={KAKAO_CALLBACK_URI}"
        headers = {"Content-type": "application/x-www-form-urlencoded;charset=utf-8"}
        token_response = requests.post(token_url, headers=headers)
        if token_response.status_code != 200:
            raise Exception

        # kakao에 회원 정보 요청
        access_token = token_response.json()['access_token']
        user_info = f"https://kapi.kakao.com/v2/user/me"
        headers = {"Authorization": "Bearer " + access_token,
                   "Content-type": "application/x-www-form-urlencoded;charset=utf-8"}
        user_response = requests.post(user_info, headers=headers)
        if user_response.status_code != 200:
            raise Exception
    except:
        raise Exception("kakao oauth error")

    info = user_response.json()['kakao_account']
    name = info.get('name') if info.get('name') else info.get('profile').get('nickname')
    return SocialMember(
        name=name,
        email=info.get('email'),
        provider=PROVIDER_ENUM.KAKAO.name
    )

def auth_naver(code: str):
    try:
        # naver에 access token 요청
        token_url = f"https://nid.naver.com/oauth2.0/token?client_id={NAVER_CLIENT_ID}&client_secret={NAVER_SECRET}&code={code}&grant_type=authorization_code&state={STATE}"
        token_response = requests.post(token_url)
        if token_response.status_code != 200:
            raise Exception

        # naver에 회원 정보 요청
        access_token = token_response.json()['access_token']
        user_info = f"https://openapi.naver.com/v1/nid/me"
        headers = { "Authorization": "Bearer "+access_token }
        user_response = requests.post(user_info, headers=headers)
        if user_response.status_code != 200:
            raise Exception
    except:
        raise Exception("naver oauth error")

    info = user_response.json()['response']
    return SocialMember(
        name=info.get('name'),
        email=info.get('email'),
        provider=PROVIDER_ENUM.NAVER.name
    )