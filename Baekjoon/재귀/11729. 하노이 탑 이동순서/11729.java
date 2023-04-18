import java.util.Scanner;

public class HanoiTower {
    // N : 원판의 개수
    // start : 첫 번째 장대
    // mid : 두 번째 장대
    // to : 세 번째 장대
    public static int cnt = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void Hanoi(int N, int start, int mid, int to) {
        if(N == 1) { // 원판이 1개일 때
            sb.append(start + " " + to + "\n"); // 원판을 to로 이동
            cnt++; // 이동 횟수 카운팅
            return; // 종료
        }
        else {
            Hanoi(N - 1, start, to, mid); // N-1번째 원판이 start -> mid로 이동
            sb.append(start + " " + to + "\n"); // N번째 원판이 start -> to로 이동
            cnt++;
            Hanoi(N - 1, mid, start, to); // mid에 있던 N-1번째 원판이 mid -> to로 이동
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
}