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
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + Integer.parseInt(st2.nextToken());
            }
        }

        for (int a = 0; a < M; a++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st3.nextToken());
            int y1 = Integer.parseInt(st3.nextToken());
            int x2 = Integer.parseInt(st3.nextToken());
            int y2 = Integer.parseInt(st3.nextToken());

            bw.write((sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]) + "\n");
        }

        br.close();
        bw.close();
    }
}
