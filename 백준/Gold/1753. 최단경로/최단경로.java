import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점의 개수 V와 간선의 개수 E, 시작 정점의 번호 K, E개의 줄에 u, v, w 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접 리스트 u번째에 v, w 넣기
        // u에서 v로 가는 가중치 w인 간선
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
        }

        // 최단 거리 테이블 초기화, 출발점은 0으로 초기화
        long[] distance = new long[V+1];
        long INF = Long.MAX_VALUE;
        for (int i = 0; i <= V; i++) {
            distance[i] = INF;
        }
        distance[K] = 0;

        // 거리 오름차순으로 정렬, 최소가 항상 맨 위가 되도록 유지
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[] {0L, K});
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];
            if (d != distance[u]) {
                continue;
            }

            for (int[] element : list[u]) {
                int v = element[0], w = element[1];
                long nowD = d + w;
                if (nowD < distance[v]) {
                    distance[v] = nowD;
                    pq.add(new long[] {nowD, v});
                }
            }
        }

        // 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 V개의 줄에 걸쳐 출력
        // 시작점 자신은 0, 경로가 존재하지 않는 경우는 INF 출력
        for (int i = 1; i <= V; i++) {
            if (distance[i] >= INF/2) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
    }
}
