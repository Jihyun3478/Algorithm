import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 포도주 잔의 개수와 각 포도주의 양 입력받기
        int glassCount = Integer.parseInt(br.readLine());

        int[] amounts = new int[glassCount + 1];
        for (int i = 1; i <= glassCount; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[glassCount + 1];
        // 1번째 포도주를 마심
        if (glassCount >= 1) {
            dp[1] = amounts[1];
        }
        // 2번째 포도주를 마심
        if (glassCount >= 2) {
            dp[2] = amounts[1] + amounts[2];
        }

        for (int i = 3; i <= glassCount; i++) {
            // 연속 3칸 금지
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amounts[i], dp[i - 3] + amounts[i - 1] + amounts[i]));
        }

        bw.write(String.valueOf(dp[glassCount]));
        bw.flush();
    }
}
