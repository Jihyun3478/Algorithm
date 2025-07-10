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

        // n 입력받기
        int n = Integer.parseInt(br.readLine());

        // n개의 수 입력받기
        double[] scores = new double[n];
        double max = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            // 최댓값 m 찾기
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        // 점수 새로 계산 및 합산
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scores[i] / max * 100;
        }

        // 평균 출력
        bw.write(String.valueOf(sum / n));

        br.close();
        bw.close();
    }
}
