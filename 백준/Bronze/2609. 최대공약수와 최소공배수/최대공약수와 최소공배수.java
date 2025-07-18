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
        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        int min = Math.min(number1, number2);
        int temp = 0;
        int gcd = Integer.MIN_VALUE;

        for (int i = 1; i <= min; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                temp = i;
                if (temp > gcd) {
                    gcd = temp;
                }
            }
        }

        int lcm = 0, index = 1;
        while (true) {
            lcm = gcd;
            lcm *= index;
            if (lcm % number1 == 0 && lcm % number2 == 0) {
                break;
            } else {
                index++;
            }
        }

        bw.write(gcd + "\n" + lcm);

        br.close();
        bw.close();
    }
}
