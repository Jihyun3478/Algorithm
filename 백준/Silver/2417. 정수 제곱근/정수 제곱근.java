import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        
        if (n == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        long left = 1;
        long right = n;
        long floor = 0L;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid <= n / mid) {
                floor = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long answer = 0L;
        if (n / floor == floor && n % floor == 0) {
            answer = floor;
        } else {
            answer = floor + 1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
