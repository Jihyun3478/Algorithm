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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st2.nextToken());
        }

        int answerCount = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            if (numbers[i] == 1) {
                continue;
            }
            for (int j = numbers[i]; j > 0; j--) {
                if (numbers[i] % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                answerCount++;
            }
        }
        bw.write(answerCount + "");

        br.close();
        bw.close();
    }
}
