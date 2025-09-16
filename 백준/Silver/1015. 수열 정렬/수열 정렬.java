import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열의 크기와 배열의 원소 입력 받기
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = i;
        }
        int[][] B = Arrays.copyOf(A, N);
        Arrays.sort(B, Comparator.comparingInt((int[] b) -> b[0]));

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[B[i][1]] = i;
        }

        for (int i = 0; i < N; i++) {
            bw.write(P[i] + " ");
        }
        bw.flush();
    }
}
