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

        // 조카의 수 M, 과자의 수 N, N개의 과자의 길이 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snackLengths = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snackLengths[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snackLengths);

        // 주어진 막대 과자들의 길이 중, 모든 조카에게 줄 수 있는 과자의 최대 길이 구하기
        long left = 1;
        long right = snackLengths[N-1];
        long maxLength = 0L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0L;

            for (long snackLength : snackLengths) {
                if (snackLength >= mid) {
                    sum += snackLength / mid;
                }
            }

            if (sum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                maxLength = Math.max(maxLength, mid);
            }
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();
    }
}
