from celery import Celery

# 브로커로 Redis 사용
app = Celery('celery_test', broker='redis://localhost:6379/0')

# 작업 결과 Redis에 저장
app.conf.update(
    result_backend='redis://localhost:6379/0',
)

@app.task
def add(x, y):
    print(f"Adding {x} + {y}")
    return x + y

@app.task
def multiply(x, y):
    print(f"Multiplying {x} * {y}")
    return x * y

@app.task
def add_all(numbers):
    print(f"sum {numbers}")
    return sum(numbers)