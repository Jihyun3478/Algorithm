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

        // K, N, K개의 랜선의 길이 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lans);

        // 이분탐색을 이용해서 N개의 랜선을 만들 수 있는 최대 랜선의 길이 구하기
        long left = 1;
        long right = lans[K - 1];
        long maxLength = 0L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0L;

            for (int lan : lans) {
                sum += lan / mid;
            }

            if (sum >= N) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        bw.write(String.valueOf(maxLength));
        bw.flush();
    }
}

