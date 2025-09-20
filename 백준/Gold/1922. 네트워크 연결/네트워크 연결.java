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
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 컴퓨터의 수와 연결할 수 있는 선의 수 입력받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        // 간선 배열 입력받기
        List<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, 1});

        int sum = 0, picked = 0;
        while (!pq.isEmpty() && picked < N) {
            int[] current = pq.poll();
            int c = current[0];
            int u = current[1];

            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            sum += c;
            picked++;

            for (int[] a : adj[u]) {
                int a0 = a[0];
                int a1 = a[1];
                if (!visited[a0]) {
                    pq.add(new int[] {a1, a0});
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
