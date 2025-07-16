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

        // 체스판 입력받기
        char[][] chess = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        // 체스판 순회해서 다시 칠해야 하는 정사각형 개수 카운팅
        // -> 기준 : W 다음은 B, B 다음은 W, 윗줄 맨 처음 시작이 W 였다면 다음 줄의 시작은 B
        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                int wStartCount = 0;
                int bStartCount = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        char current = chess[k][l];
                        char expectedW, expectedB;

                        if ((k+l) % 2 == 0) {
                            expectedW = 'W';
                        } else {
                            expectedW = 'B';
                        }

                        if ((k+l) % 2 == 0) {
                            expectedB = 'B';
                        } else {
                            expectedB = 'W';
                        }

                        if (current != expectedW) {
                            wStartCount++;
                        }

                        if (current != expectedB) {
                            bStartCount++;
                        }
                    }
                }
                count = Math.min(count, Math.min(wStartCount, bStartCount));
            }
        }

        bw.write(count + "");

        br.close();
        bw.close();
    }
}
