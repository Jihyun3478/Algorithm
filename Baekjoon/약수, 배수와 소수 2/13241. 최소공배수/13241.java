import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long d = gcd(A, B);

        sb.append(A * B / d).append("\n");
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if(a == 1 && b == 1) return 1;
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}