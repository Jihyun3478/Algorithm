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

        // N: 지역 수, M: 수색 범위(최대 이동 거리), R: 길의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 각 지역의 아이템 수
        int[] items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 거리 초기화
        final int INF = 1_000_000_000;
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // 양방향 도로 입력 (멀티간선 최소값 반영)
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (l < dist[a][b]) {
                dist[a][b] = l;
                dist[b][a] = l;
            }
        }

        // 플로이드–워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= N; j++) {
                    if (dist[k][j] == INF) continue;
                    int nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) {
                        dist[i][j] = nd;
                    }
                }
            }
        }

        // 각 시작점에서 수색 범위 M 이내 아이템 합의 최대값 계산
        int ans = 0;
        for (int s = 1; s <= N; s++) {
            int sum = 0;
            for (int t = 1; t <= N; t++) {
                if (dist[s][t] <= M) {
                    sum += items[t];
                }
            }
            if (sum > ans) ans = sum;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
