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
        int numer = Integer.parseInt(st.nextToken());
        int denom = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int numer2 = Integer.parseInt(st.nextToken());
        int denom2 = Integer.parseInt(st.nextToken());

        int sumNumer = denom2*numer + denom*numer2;
        int sumDenom = denom*denom2;
        int d = gcd(sumNumer, sumDenom);

        sumNumer /= d;
        sumDenom /= d;

        sb.append(sumNumer).append(" ").append(sumDenom);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if(a == 1 && b == 1) return 1;
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}