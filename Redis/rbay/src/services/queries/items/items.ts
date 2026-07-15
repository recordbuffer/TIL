import type { CreateItemAttrs } from '$services/types';
import { client } from '$services/redis';
import { serialize } from './serialize';
import { deserialize } from './deserialize';
import { genId } from '$services/utils';
import { itemsKey, itemsByViewsKey, itemsByEndingAtKey } from '$services/keys';


export const getItem = async (id: string) => {
    const item = await client.hGetAll(itemsKey(id));

    if (Object.keys(item).length === 0) {
        return null;
    }
    return deserialize(id, item); 
};

export const getItems = async (ids: string[]) => {
    const commands = ids.map((id) => {
        return client.hGetAll(itemsKey(id));
    });
    const results = await Promise.all(commands);

    return results.map((r, i )=> {
        if (Object.keys(r).length === 0) {
            return null;
        }
        return deserialize(ids[i], r);
    });
};

export const createItem = async (attrs: CreateItemAttrs, userId: string) => {
    const id = genId();

    const serialized = serialize(attrs);

    await Promise.all([
        client.hSet(itemsKey(id), serialized),
        client.zAdd(itemsByViewsKey(), { // 아이템마다 조회수 저장할 sorted set 생성
            value: id,
            score: 0
        }),
        client.zAdd(itemsByEndingAtKey(), { // 아이템마다 마감시간 저장할 sorted set 생성
            value: id,
            score: attrs.endingAt.toMillis()
        })
    ]);

    return id;
};
