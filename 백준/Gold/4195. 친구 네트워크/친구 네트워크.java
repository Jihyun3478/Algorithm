import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<String, Integer> id;
    private static int[] parent;
    private static int[] size;
    private static int nextId;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 개수 입력받기
        int T = Integer.parseInt(br.readLine());

        // 친구 관계의 수와 친구 관계가 생긴 순서대로 이름 입력받기
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            id = new HashMap<>();
            parent = new int[2 * F + 1];
            size = new int[2 * F + 1];
            nextId = 1;
            
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int a = getId(name1);
                int b = getId(name2);
                int answer = union(a, b);
                bw.write(answer + "\n");
            }
        }
        bw.flush();
    }

    private static int getId(String name) {
        if (!id.containsKey(name)) {
            id.put(name, nextId);
            parent[nextId] = nextId;
            size[nextId] = 1;
            nextId++;
        }
        return id.get(name);
    }

    private static int find(int a) {
        // i가 자식 노드일 경우, 부모 노드에 대해 재귀실행 함
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        // i가 root 이면 그대로 반환
        return parent[a];
    }

    private static int union(int a, int b) {
        int ra = find(a), rb = find(b);

        if (ra == rb) {
            return size[ra];
        }
        
        if (size[ra] < size[rb]) {
            int t = ra;
            ra = rb;
            rb = t;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
        
        return size[ra];
    }
}
