import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sub = br.readLine().split("-");

        int[] sum = new int[sub.length];
        for (int i = 0; i < sub.length; i++) {
            String[] split = sub[i].split("\\+");
            int temp = 0;

            for (String s : split) {
                temp += Integer.parseInt(s);
            }
            sum[i] = temp;
        }

        int answer = sum[0];
        for (int i = 1; i < sum.length; i++) {
            answer -= sum[i];
        }
        bw.write(answer + "");


        br.close();
        bw.close();
    }
}
