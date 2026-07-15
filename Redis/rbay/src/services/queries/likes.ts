import { client } from '$services/redis';
import { userLikesKey, itemsKey } from '$services/keys';
import { getItems } from './items'

export const userLikesItem = async (itemId: string, userId: string) => {
    return client.sIsMember(userLikesKey(userId), itemId);
};

export const likedItems = async (userId: string) => {
    // 유저의 좋아요 목록의 모든 아이템 가져오기
    const ids = await client.sMembers(userLikesKey(userId));

    return getItems(ids);
};

export const likeItem = async (itemId: string, userId: string) => {
    const inserted = await client.sAdd(userLikesKey(userId), itemId);
    // 더블클릭 추적 제한 -> 좋아요 들어간 경우 = 1 리턴
    if (inserted) {
        // 유저의 좋아요 들어간 경우 아이템의 좋아요 수에도 반영
        return client.hIncrBy(itemsKey(itemId), 'likes', 1);
    }

};

export const unlikeItem = async (itemId: string, userId: string) => {
    const removed = await client.sRem(userLikesKey(userId), itemId);
    if (removed) {
        // 유저의 좋아요 삭제된 경우 아이템의 좋아요 수에도 반영
        return client.hIncrBy(itemsKey(itemId), 'likes', -1);
    }
};

export const commonLikedItems = async (userOneId: string, userTwoId: string) => {
    const ids = await client.sInter([userLikesKey(userOneId), userLikesKey(userTwoId)]);

    return getItems(ids);
};
