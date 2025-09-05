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

        // N, N개의 예산 요청, 총 예산 M 입력받기
        int N = Integer.parseInt(br.readLine());

        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = budgets[N - 1];
        int maxLength = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            // 총 합이 최대가 될 수 있는 예산
            for (int i = 0; i < N; i++) {
                sum += Math.min(mid, budgets[i]);
            }

            if (sum > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                maxLength = Math.max(maxLength, mid);
            }
        }

        // 배정된 예산액 중 가장 큰 값 출력
        bw.write(String.valueOf(maxLength));
        bw.flush();
    }
}
