import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int index = Integer.parseInt(st.nextToken());
                broken[index] = true;
            }
        }

        int answer = Math.abs(N - 100);
        for (int i = 0; i <= 1000000; i++) {
            String str = String.valueOf(i);
            int length = str.length();

            boolean isBreak = false;
            for (int j = 0; j < length; j++) {
                if (broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                int min = Math.abs(N - i) + length;
                answer = Math.min(min, answer);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
