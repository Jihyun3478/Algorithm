### [BOJ] 2751. 수 정렬하기2

---

#### ✔️ Problem URL
[수 정렬하기2](https://www.acmicpc.net/problem/2751)

#### ✔️ Problem
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

💡 해당 문제는 Arrays.sort()+Scanner를 이용하거나 quickSort+Scanner를 구현해도 시간 초과가 발생했다.
찾아보니 입출력 부분에서 BufferReader+StringBuilder를 사용할 경우 성능이 더 좋다는 것을 알게 되었다. 또한 정렬 알고리즘 중 카운팅 정렬이 비교적 효율적이라는 것도 알게 되었다.
따라서 카운팅 정렬과 BufferReader+StringBuilder를 이용해 문제를 해결하였다. 단, 카운팅 정렬 같은 경우 수의 개수보다 범위가 너무 크면 메모리 낭비가 발생한다는 점을 유의해두어야 한다.

#### ✔️ 성능
<img src="" width="550" height="50"/>