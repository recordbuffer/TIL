import type { CreateUserAttrs } from '$services/types';
import { genId } from '$services/utils';
import { client } from '$services/redis';
import { usersKey, usernamesUniqueKey, usernamesKey } from '$services/keys';


export const getUserByUsername = async (username: string) => {
    // 유저 정보가 있는지 확인
    const decimalId = await client.zScore(usernamesKey(), username);
    if (!decimalId) {
        throw new Error('user does not exist');
    }

    const id = decimalId.toString(16); // 16 진수로 다시 변환
    const user = await client.hGetAll(usersKey(id));  // 유저 정보 가져옴

    return deserialize(id, user);
};

export const getUserById = async (id: string) => {
    const user = await client.hGetAll(usersKey(id));

    return deserialize(id, user);
};

export const createUser = async (attrs: CreateUserAttrs) => {
    const id = genId();
    
    // 유저 이름 고유성 유지
    const exists = await client.sIsMember(usernamesUniqueKey(), attrs.username);
    if (exists) {
        throw new Error('username is taken');
    }

    // 생성한 임의의 id로 hset 데이터 구조로 유저 저장
    await client.hSet(usersKey(id), serialize(attrs));
    // 생성한 유저 이름 set에 저장
    await client.sAdd(usernamesUniqueKey(), attrs.username);

    // 가입시 유저 정보를 id와 함께 sorted set에 저장
    await client.zAdd(usernamesKey(), {
        value: attrs.username,
        score: parseInt(id, 16)  // 10 진수로 저장 
    });

    return id;
};

const serialize = (user: CreateUserAttrs) => {
    return {
        username: user.username,
        password: user.password
    };
};


const deserialize = (id: string, user: { [key: string]: string }) => {
    return {
        id: id, 
        username: user.username,
        password: user.password
    };
};