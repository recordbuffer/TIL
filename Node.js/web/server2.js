const http = require('http');
const fs = require('fs');
http.createServer((req, res) => {
    fs.readFile('web/server2.html', (err, data) => {        // fs 모듈로 html 파일 읽어옴
        if (err) {
            throw err;
        }
        res.end(data);
    });
}).listen(8081, () => {
    console.log('8081번 포트에서 서버 대기 중입니다!');       // 포트 다르게 해서 여러 노드 서버 실행 가능
});