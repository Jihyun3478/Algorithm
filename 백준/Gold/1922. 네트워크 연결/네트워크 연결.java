import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 컴퓨터의 수와 연결할 수 있는 선의 수 입력받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 간선 배열 입력받기
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        // 간선 배열 오름차순 정렬
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        int picked = 0, sum = 0;
        for (int i = 0; i < M && picked != N - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];

            // 최소 스패닝 트리 MST 구성
            if (find(a) != find(b)) {
                union(a, b);
                sum += c;
                picked++;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    public static int find(int x) {
        // x가 자식 노드일 경우, 부모 노드에 대해 재귀실행 함
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        // x가 root 이면 그대로 반환
        return parent[x];
    }

    public static void union(int x, int y) {
        // x, y 정점의 최상위 정점을 각각 찾음 (속한 트리의 루트 노드를 찾음)
        x = find(x);
        y = find(y);

        if (x != y) {
            // 서로 다른 트리에 속한다면, 한 쪽의 트리를 다른 쪽에 붙임
            parent[x] = y;
        }
    }
}
