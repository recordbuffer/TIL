import { client } from '$services/redis';
import type { CreateBidAttrs, Bid } from '$services/types';
import { bidHistoryKey  } from '$services/keys';
import { DateTime } from 'luxon';

export const createBid = async (attrs: CreateBidAttrs) => {
	//  입찰가:시간 저장
	const seralized = serializeHistory(
		attrs.amount, 
		attrs.createdAt.toMillis()
	);

	return client.rPush(bidHistoryKey(attrs.itemId), seralized);
};

export const getBidHistory = async (itemId: string, offset = 0, count = 10): Promise<Bid[]> => {
	const startIndex = -1 * offset - count;
	const endIndex = -1 - offset;

	const range = await client.lRange(
		bidHistoryKey(itemId),
		startIndex,
		endIndex
	)

	// 객체 배열을 리턴
	return range.map(bid => deserializeHistory(bid));
};

const serializeHistory = (amount: number, createdAt: number) => {
	return `${amount}:${createdAt}`;
};

const deserializeHistory = (stored: string) => {
	const [amount, createdAt] = stored.split(':');

	return {
		amount: parseFloat(amount),
		createdAt: DateTime.fromMillis(parseInt(createdAt))
	};
};