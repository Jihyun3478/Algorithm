import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> card = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            card.put(st.nextToken(), 0);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            if(card.get(st.nextToken()) != null) {
                sb.append("1 ");
            }
            else {
                sb.append("0 ");
            }
        }
        System.out.print(sb);
    }
}