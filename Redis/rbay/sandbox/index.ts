import 'dotenv/config';
import { client } from '../src/services/redis';

const run = async () => {
    await client.hSet('car1', {
        color:'red',
        year: 1950
    });
    await client.hSet('car2', {
        color:'blue',
        year: 1980
    });
    await client.hSet('car3', {
        color:'green',
        year: 1990
    });

    const commands = [1,2,3].map((id) => {
        return client.hGetAll('car'+id);
    });

    const results = await Promise.all(commands);

    console.log(results);
};
run();
