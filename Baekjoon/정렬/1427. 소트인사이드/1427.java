import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = Integer.toString(N);
        Integer[] arr = new Integer[str.length()];
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i : arr) {
            answer *= 10;
            answer += i;
        }
        System.out.println(answer);
    }
}
