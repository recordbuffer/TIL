const A = require('./globalA');
global.message ='안녕하세요';
console.log(A());   // globalA에서도 global.message 접근 가능함 => global 전역 객체