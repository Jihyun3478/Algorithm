import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나무의 수 N 입력받기
        int N = Integer.parseInt(st.nextToken());

        // 상근이가 필요한 나무의 길이 M 입력받기
        int M = Integer.parseInt(st.nextToken());

        // N개의 나무의 길이 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] heightOfTrees = new int[N];
        for (int i = 0; i < N; i++) {
            heightOfTrees[i] = Integer.parseInt(st2.nextToken());
        }

        // 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값
        // 정렬
        Arrays.sort(heightOfTrees);
        long left = 0;
        long right = heightOfTrees[N-1];
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (heightOfTrees[i] > mid) {
                    sum += heightOfTrees[i] - mid;
                }
            }

            if (sum >= M) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // M과 가장 근접한 최댓값 출력
        bw.write(answer + "");

        br.close();
        bw.close();
    }
}
