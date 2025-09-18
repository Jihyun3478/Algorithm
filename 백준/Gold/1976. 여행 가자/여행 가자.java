import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 수와 각 계단에 쓰여 있는 점수 입력받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    union_root(i + 1, j + 1);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
        root = find_root(plan[0]);

        boolean isRoot = true;
        for (int i = 0; i < M; i++) {
            if (find_root(plan[i]) != root) {
                isRoot = false;
            }
        }
        if (isRoot) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
    }

    private static int find_root(int i) {
        // i가 자식 노드일 경우, 부모 노드에 대해 재귀실행 함
        if (i != parent[i]) {
            parent[i] = find_root(parent[i]);
        }
        // i가 root 이면 그대로 반환
        return parent[i];
    }

    private static void union_root(int i, int j) {
        // i, j 정점의 최상위 정점을 각각 찾음 (속한 트리의 루트 노드를 찾음)
        i = find_root(i);
        j = find_root(j);

        if (i != j) {
            // 서로 다른 트리에 속한다면, 한 쪽의 트리를 다른 쪽에 붙임
            parent[i] = j;
        }
    }
}
