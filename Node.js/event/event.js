const EventEmitter = require('events');     // events 모듈 사용
const myEvent = new EventEmitter();         // myevent 객체 생성
myEvent.addListener('event1', () => {
    console.log('이벤트 1');
});

myEvent.on('event2', () => {
    console.log('이벤트 2');
});

myEvent.on('event2', () => {
    console.log('이벤트 2 추가');
});

myEvent.emit('event1');             // 이벤트 호출 메소드
myEvent.emit('event2');
myEvent.once('event3', () => {      // 이벤트 한번만 실행
    console.log('이벤트 3');
});

myEvent.emit('event3');
myEvent.emit('event3');
myEvent.on('event4', () => {
    console.log('이벤트 4');
});

myEvent.removeAllListeners('event4');   // 이벤트 제거
myEvent.emit('event4');
const listener = () => {
    console.log('이벤트 5');
};

myEvent.on('event5', listener);
myEvent.removeListener('event5', listener);
myEvent.emit('event5');
console.log(myEvent.listenerCount('event2'));