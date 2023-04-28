import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int gcd = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N-1; i++) {
            int distance = arr[i+1] - arr[i];
            gcd = GCD(distance, gcd);
        }
        System.out.println((arr[N-1] - arr[0]) / gcd + 1 - arr.length);
    }

    public static int GCD(int a, int b) {
        if(a == 1 && b == 1) return 1;
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}