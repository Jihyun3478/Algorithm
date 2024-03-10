### [코딩 기초 트레이닝] 181939. 더 크게 합치기

---
 
#### ✔️ Problem URL
[더 크게 합치기](https://school.programmers.co.kr/learn/courses/30/lessons/181939)

#### ✔️ Problem
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

12 ⊕ 3 = 123
3 ⊕ 12 = 312
양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.

단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.

#### ✔️ 성능

##### 리팩토링 전
<img src="https://velog.velcdn.com/images/ljh3478/post/cd9f9133-b9f9-4000-8d8c-d7844c256028/image.png" width="200" height="450"/>

##### 리팩토링 후
불필요하게 반복되는 코드를 리팩토링하였다.

<img src="https://velog.velcdn.com/images/ljh3478/post/76ccd70f-8c7e-4e23-bde0-e74b004c59a1/image.png" width="200" height="450"/>