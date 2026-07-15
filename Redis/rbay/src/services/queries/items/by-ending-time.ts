import { client } from '$services/redis';
import { itemsKey, itemsByEndingAtKey } from '$services/keys';
import { deserialize } from './deserialize';

export const itemsByEndingTime = async (
	order: 'DESC' | 'ASC' = 'DESC',
	offset = 0,
	count = 10
) => {
	const ids = await client.zRange(
		itemsByEndingAtKey(),
		Date.now(),
		'+inf',
		{
			BY: 'SCORE',
			LIMIT: {
				offset,
				count
			}
		}
	);
	// 하나의 파이프라인으로 한번에 명령어 처리
	const results = await Promise.all(ids.map(id => client.hGetAll(itemsKey(id))));
	return results.map((item, i) => deserialize(ids[i], item));
};
