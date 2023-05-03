import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int prev = 0, sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        for(int i = 0; i < N; i++) {
            sum += prev + time[i];

            prev += time[i];
        }
        System.out.println(sum);
    }
}