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
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(P);
        int[] sum = new int[N + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + P[i-1];
            answer += sum[i];
        }
        bw.write(answer + "");

        br.close();
        bw.close();
    }
}
