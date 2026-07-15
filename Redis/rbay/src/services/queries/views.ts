import { client } from '$services/redis';
import { itemsKey, itemsByViewsKey, itemsViewsKey } from '$services/keys';

export const incrementView = async (itemId: string, userId: string) => {
    // HyperLogLog에 userId 저장함
    const inserted = await client.pfAdd(itemsViewsKey(itemId), userId);
    
    // 저장되었다면 view 증가
    if (inserted) {
        return Promise.all([
            client.hIncrBy(itemsKey(itemId), 'views', 1),   // 아이템에 views +1
            client.zIncrBy(itemsByViewsKey(), 1, itemId)     // 아이템 view sorted set에 +1
        ]);
    }
};