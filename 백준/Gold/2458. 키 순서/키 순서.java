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

        boolean[][] reach = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reach[a][b] = true;
        }

        // 플로이드 알고리즘 수행, 최솟값 갱신
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            boolean known = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (!reach[i][j] && !reach[j][i]) {
                    known = false;
                    break;
                }
            }
            if (known) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
