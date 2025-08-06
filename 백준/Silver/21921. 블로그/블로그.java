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
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st2.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = X; i <= N; i++) {
            int temp = sum[i] - sum[i - X];

            if (max < temp) {
                max = temp;
                count = 1;
            } else if (max == temp) {
                count++;
            }
        }

        if (max > 0) {
            bw.write(max + "\n" + count);
        } else {
            bw.write("SAD");
        }

        br.close();
        bw.close();
    }
}
