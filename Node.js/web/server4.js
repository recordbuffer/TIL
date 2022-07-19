const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');
const parseCookies = (cookie = '') =>
    cookie
        .split(';')
        .map(v => v.split('='))
        .map(([k, ...vs]) => [k, vs.join('=')])
        .reduce((acc, [k, v]) => {
            acc[k.trim()] = decodeURIComponent(v);
            return acc;
        }, {});
http.createServer((req, res) => {
    const cookies = parseCookies(req.headers.cookie);
    if (req.url.startsWith('/login')) {                                         // 주소가 /login으로 시작하는 경우
        const { query } = url.parse(req.url);                                   // 딸려오는 query 분석함
        const { name } = qs.parse(query);
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 1);                        // 쿠키 만료 시간은 1분 뒤로 설정
        res.writeHead(302, {
            Location: '/',
            'Set-Cookie': `name=${encodeURIComponent(name)};Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
        });                                                                 // 쿠키 설정     HttpOnly : JS에서 쿠키 접근 불가
        res.end();
    } else if (cookies.name) {                                                   // 쿠키 있는 경우 읽어 옴
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(`${cookies.name}님 안녕하세요`);
    } else {
        fs.readFile('web/server4.html', (err, data) => {                         // 쿠키 없는 경우 server4.html 
            if (err) {
                throw err;
            }
            res.end(data);
        });
    }
})
    .listen(8083, () => {
        console.log('8083번 포트에서 서버 대기 중입니다!');
    });
