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
        int K = Integer.parseInt(st.nextToken());

        int numerator = 1;
        int count1 = 0;
        for (int i = N; i > 0; i--) {
            if (count1 == K) {
                break;
            }
            numerator *= i;
            count1++;
        }

        int denominator = 1;
        int count2 = 0;
        for (int i = K; i > 0; i--) {
            if (count2 == K) {
                break;
            }
            denominator *= i;
            count2++;
        }

        int answer = 0;
        if (K == 0) {
            answer = 1;
        }
        answer = numerator / denominator;
        bw.write(answer + "");

        br.close();
        bw.close();
    }
}
