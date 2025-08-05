import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st2.nextToken());
        }

        for (int a = 0; a < M; a++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st3.nextToken());
            int j = Integer.parseInt(st3.nextToken());

            bw.write((sum[j] - sum[i-1]) + "\n");
        }


        br.close();
        bw.close();
    }
}
