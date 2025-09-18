import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 계단의 개수와 각 계단에 쓰여 있는 점수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union_root(a, b);
            } else if (num == 1) {
                find_root(a);
                if (find_root(a) == find_root(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
    }

    public static int find_root(int x) {
        // x가 root 이면 그대로 반환
        if (x != parent[x]) {
            parent[x] = find_root(parent[x]);
        }
        // x가 자식 노드일 경우, 부모 노드에 대해 재귀실행 함
        return parent[x];
    }

    public static void union_root(int x, int y) {
        // x, y 정점의 최상위 정점을 각각 찾음 (속한 트리의 루트 노드를 찾음)
        x = find_root(x);
        y = find_root(y);

        if (x != y) {
            // 서로 다른 트리에 속한다면, 한 쪽의 트리를 다른 쪽에 붙임
            parent[x] = y;
        }
    }
}
