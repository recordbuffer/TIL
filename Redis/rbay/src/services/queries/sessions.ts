import type { Session } from '$services/types';
import { client } from '$services/redis';
import { sessionsKey } from '$services/keys';

export const getSession = async (id: string) => {
    const session = await client.hGetAll(sessionsKey(id));

    // 세션이 있는지 확인 (user 로그인 안함)
    if (Object.keys(session).length === 0) {
        return null;
    }
    return deserialize(id, session);
};

export const saveSession = async (session: Session) => {
    return client.hSet(
        sessionsKey(session.id),
        serialize(session)
    )
};

const serialize = (session: Session) => {
    return {
        userId: session.userId,
        username: session.username
    };
};

const deserialize = (id: string, session: { [key: string]: string }) => {
    return {
        id: id, 
        userId: session.userId,
        username: session.username
    };
};