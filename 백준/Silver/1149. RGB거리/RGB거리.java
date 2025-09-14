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

        // 집의 수와 각 집을 칠하는 비용 입력받기
        int houseCount = Integer.parseInt(br.readLine());

        int[][] costs = new int[houseCount + 1][3];
        for (int i = 1; i <= houseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[houseCount + 1][3];
        for (int i = 1; i <= houseCount; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = Math.min(dp[houseCount][0], Math.min(dp[houseCount][1], dp[houseCount][2]));
        bw.write(String.valueOf(min));
        bw.flush();
    }
}
