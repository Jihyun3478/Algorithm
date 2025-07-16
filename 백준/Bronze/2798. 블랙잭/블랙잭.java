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

        // N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 플레이어가 뽑은 카드 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] pickCards = new int[N];
        for (int i = 0; i < N; i++) {
            pickCards[i] = Integer.parseInt(st2.nextToken());
        }

        // 플레이어가 갖고있는 N개의 카드 중 3장의 합이 M보다 작거나 같아야 함제일 가까워야 함
        int min = Integer.MAX_VALUE; // M - sum이 가장 작을 때의 값
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    sum = pickCards[i] + pickCards[j] + pickCards[k];

                    if (sum <= M) {
                        // 플레이어가 갖고있는 N개의 카드 중 3장의 합이 M에 제일 가까워야 함
                        min = Math.min(min, M - sum);
                    }
                }
            }
        }

        // 찾은 카드 3장의 합 출력
        bw.write((M-min) + "");

        br.close();
        bw.close();
    }
}
