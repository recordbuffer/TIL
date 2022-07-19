const http = require('http');
http.createServer((req, res) => {
    res.write('<h1>Hello Node!</h1>');              // 클라이언트로 보낼 데이터
    res.end('<p>Hello Server!</p>');                // 응답 종료 메소드 
}).listen(8080, () => {
    console.log('8080번 포트에서 서버 대기 중입니다!');
});