import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[N + 1];
        StringBuilder dfs = new StringBuilder();
        dfs(V, graph, visited, dfs);
        bw.write(dfs.toString().trim() + "\n");

        visited = new boolean[N + 1];
        StringBuilder bfs = new StringBuilder();
        bfs(V, graph, visited, bfs);
        bw.write(bfs.toString().trim());

        br.close();
        bw.close();
    }

    public static void dfs(int cur, List<Integer>[] graph, boolean[] visited, StringBuilder result) {
        visited[cur] = true;
        result.append(cur).append(' ');
        for (int nxt : graph[cur]) {
            if (!visited[nxt]) dfs(nxt, graph, visited, result);
        }
    }

    public static void bfs(int start, List<Integer>[] graph, boolean[] visited, StringBuilder result) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.append(cur).append(' ');
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
    }
}
