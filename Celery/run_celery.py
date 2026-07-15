from celery import chain, group, chord
from tasks import add, multiply, add_all

def test_simple():
    # 작업을 큐에 추가 (비동기로 실행)
    result1 = add.delay(4, 6)
    result2 = multiply.delay(3, 7)

    # 작업 결과 확인
    print(f"Task 1 ID: {result1.id}")
    print(f"Task 2 ID: {result2.id}")
    print(f"Task 1 result: {result1.get(timeout=10)}")
    print(f"Task 2 result: {result2.get(timeout=10)}")

def test_workflow():
    workflow_chain = chain(multiply.s(2, 2) | add.s(10))
    result_chain = workflow_chain()
    print(result_chain.get())  # 결과: 14

    workflow_group = group(multiply.s(2, 2), multiply.s(3, 2))
    result_group = workflow_group()
    print(result_group.get())  # 결과: [4, 6]

    workflow_chord = chord([multiply.s(2, 2), multiply.s(3, 2)], add_all.s())
    result = workflow_chord()

    print(result.get())  # 결과: 10

test_workflow()