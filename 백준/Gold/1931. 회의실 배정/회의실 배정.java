import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        int cnt = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            else {
                return o1[1] - o2[1];
            }
        });

        int end = schedule[0][1];
        for(int i = 1; i < N; i++) {
            if(schedule[i][0] >= end) {
                cnt++;
                end = schedule[i][1];
            }
        }
        System.out.print(cnt);
    }
}