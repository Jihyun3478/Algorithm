### [BOJ] 11729. 하노이 탑 이동순서

---

#### ✔️ Problem URL
[하노이 탑 이동순서](https://www.acmicpc.net/problem/11729)

#### ✔️ Problem
세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
   이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.

💡 하노이 탑의 알고리즘은 이렇다.
맨 처음에 첫번째 장대에 N개의 원판이 쌓여있다.

1. N-1번째 원판이 start -> mid로 이동
2. N번째 원판이 start -> to로 이동
3. mid에 있던 N-1번째 원판이 mid -> to로 이동

위 알고리즘을 재귀를 이용하여 구현하였다.

![](https://velog.velcdn.com/images/ljh3478/post/8705a4bb-14bd-4dc8-8ebe-a4c83f115d2a/image.png)

#### ✔️ 성능
<img src="https://velog.velcdn.com/images/ljh3478/post/8fb93481-0bf0-4f70-bb73-a17ee5c7b447/image.png" width="500" height="60"/>