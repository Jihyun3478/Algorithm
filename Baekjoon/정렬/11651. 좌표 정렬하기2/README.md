### [BOJ] 11651. 좌표 정렬하기2

---

#### ✔️ Problem URL
[좌표 정렬하기2](https://www.acmicpc.net/problem/11651)

#### ✔️ Problem
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

💡 해당 문제는 11650. 좌표 정렬하기 문제와 상당히 유사하다. 11650번은 x좌표를 기준으로 정렬하다가 만약 x좌표가 같은 원소가 있다면 y좌표를 기준으로 정렬하면 된다.
11651번은 맨 처음, y좌표를 기준으로 정렬한다는 점에서 차이점이 있다.

💡 정렬 문제를 풀면서 알게 된 점은 의외로 입출력에서 메모리와 실행시간의 차이가 발생한다는 것이다.

#### ✔️ 성능
* 리팩토링 전

<img src="https://velog.velcdn.com/images/ljh3478/post/1e721865-d388-4eb7-9605-d81b768ebb27/image.png" width="580" height="50"/>

* 리팩토링 후

<img src="https://velog.velcdn.com/images/ljh3478/post/00ca8f13-1128-4e2f-b1a6-e5fca1e6799a/image.png" width="580" height="50"/>