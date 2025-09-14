import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 계단의 개수와 각 계단에 쓰여 있는 점수 입력받기
        int stairCount = Integer.parseInt(br.readLine());

        int[] stairs = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[stairCount + 1];
        // 1번 계단을 밝음
        if (stairCount >= 1) {
            dp[1] = stairs[1];
        }
        // 2번 계단을 밟음
        if (stairCount >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        // 3번 계단을 밝음, 연속 3칸 금지 반영
        if (stairCount >= 3) {
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }

        for (int i = 4; i <= stairCount; i++) {
            // 연속 3칸 금지, i를 반드시 밟음
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        bw.write(String.valueOf(dp[stairCount]));
        bw.flush();
    }
}
