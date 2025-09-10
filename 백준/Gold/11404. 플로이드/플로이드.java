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

        // 도시의 개수 n, 버스의 개수 m, m개의 줄에 버스의 정보 입력 받기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 최단 거리 테이블 초기화, 출발점은 0으로 초기화
        long[][] distance = new long[n + 1][n + 1];
        long INF = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distance[i][j] = INF;
            }
            distance[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Math.min(distance[a][b], c);
        }

        // 플로이드 알고리즘 수행, 최단 거리 테이블에서 최솟값 갱신
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // n개의 줄 출력, i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용
        // i에서 j로 갈 수 없는 경우 0 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(distance[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
