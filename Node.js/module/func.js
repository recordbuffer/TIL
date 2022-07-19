const { odd, even } = require('./var');       //불러올 모듈의 경로
function checkOddOrEven(num) {
if (num % 2) { // 홀수면
  return odd;
}
  return even;
}

module.exports = checkOddOrEven;