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

        // 테스트 케이스 개수 T 입력받기
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터의 번호 c 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // d개의 줄에 각 의존성을 나타내는 정수 a, b, s 입력받기
            // 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
            List<int[]>[] list = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[b].add(new int[]{a, s});
            }

            // 최단 거리 테이블 초기화, 출발점은 0으로 초기화
            int[] distance = new int[n+1];
            int INF = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                distance[i] = INF;
            }
            distance[c] = 0;

            // 거리 오름차순으로 정렬, 최소가 항상 맨 위가 되도록 유지
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.add(new int[] {0, c});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int t = current[0], u = current[1];
                if (t != distance[u]) {
                    continue;
                }

                for (int[] element : list[u]) {
                    int v = element[0], w = element[1];
                    int nowT = t + w;
                    if (nowT < distance[v]) {
                        distance[v] = nowT;
                        pq.add(new int[] {nowT, v});
                    }
                }
            }

            int cnt = 0, last = 0;
            for (int i = 1; i <= n; i++) {
                if (distance[i] != INF) {
                    cnt++;

                    if (distance[i] > last) {
                        last = distance[i];
                    }
                }
            }
            bw.write(cnt + " " + last + "\n");
            bw.flush();
        }
    }
}
