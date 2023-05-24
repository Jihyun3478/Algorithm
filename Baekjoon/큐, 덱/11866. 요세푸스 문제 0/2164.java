import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tCase = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        while(tCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 index

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                queue.offer(new int[]{ i, Integer.parseInt(st.nextToken()) });
            }

            int cnt = 0;

            while(!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;

                for(int i = 0; i < queue.size(); i++) {

                    if(front[1] < queue.get(i)[1]) {

                        queue.offer(front);
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) {
                    continue;
                }

                cnt++;
                if(front[0] == M) {
                    break;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
