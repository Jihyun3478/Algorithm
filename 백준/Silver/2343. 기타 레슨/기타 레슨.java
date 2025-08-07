import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 수

        int[] lectures = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st2.nextToken());
        }

        long left = 0;  // 최소 블루레이 크기 (가장 긴 강의)
        long right = 0; // 최대 블루레이 크기 (전체 강의 길이 합)
        for (int i = 0; i < N; i++) {
            right += lectures[i];
            if (lectures[i] > left) {
                left = lectures[i]; // 가장 긴 강의
            }
        }

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 블루레이 용량 후보
            int count = 1; // 블루레이 개수
            long sum = 0;  // 현재 블루레이에 들어간 강의 길이 합

            for (int i = 0; i < N; i++) {
                if (sum + lectures[i] > mid) {
                    count++;           // 새 블루레이 필요
                    sum = lectures[i]; // 현재 강의를 새 블루레이에 담음
                } else {
                    sum += lectures[i]; // 현재 블루레이에 담기 가능
                }
            }

            if (count > M) { // 블루레이 개수 초과 → 용량 증가
                left = mid + 1;
            } else {         // 조건 만족 → 더 작은 용량 가능성 확인
                answer = mid;
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
