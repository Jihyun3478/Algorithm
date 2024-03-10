### [코딩 기초 트레이닝] 181938. 두 수의 연산값 비교하기

---
 
#### ✔️ Problem URL
[두 수의 연산값 비교하기](https://school.programmers.co.kr/learn/courses/30/lessons/181938)

#### ✔️ Problem
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

12 ⊕ 3 = 123
3 ⊕ 12 = 312
양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.

단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.

#### ✔️ 성능

##### 리팩토링 전
<img src="https://velog.velcdn.com/images/ljh3478/post/0f128428-200f-469b-a615-5bfc44e016d3/image.png" width="200" height="450"/>

##### 리팩토링 후
불필요하게 반복되는 코드를 리팩토링하였다.

<img src="https://velog.velcdn.com/images/ljh3478/post/0b503e06-d634-41ee-8762-ba1ecd3deecf/image.png" width="200" height="450"/>