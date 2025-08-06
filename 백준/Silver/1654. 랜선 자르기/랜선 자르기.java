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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lanLength = new int[K];
        for (int i = 0; i < K; i++) {
            lanLength[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanLength);
        long left = 1;
        long right = lanLength[K-1];
        long maxLength = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < K; i++) {
                sum += lanLength[i] / mid;
            }

            if (sum >= N) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(maxLength + "");

        br.close();
        bw.close();
    }
}
