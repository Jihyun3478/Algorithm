import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[3];

            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            if (numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0) {
                break;
            }

            Arrays.sort(numbers);
            int c2 = numbers[2] * numbers[2];
            if (c2 == (numbers[0] * numbers[0] + numbers[1] * numbers[1])) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }

        br.close();
        bw.close();
    }
}
