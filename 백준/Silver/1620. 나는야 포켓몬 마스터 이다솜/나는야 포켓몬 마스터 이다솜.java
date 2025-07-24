import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> collection = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            collection.put(name, String.valueOf(i+1));
            collection.put(String.valueOf(i+1), name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            sb.append(collection.get(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
}