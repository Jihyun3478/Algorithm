import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 자연수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 소수 판별
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 연속된 소수의 합을 나타낼 수 있는 경우의 수 구하기
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int l = 0, r = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum >= N) {
                sum -= primes.get(l++);
            } else if (r == primes.size()) {
                break;
            } else {
                sum += primes.get(r++);
            }

            if (sum == N) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
