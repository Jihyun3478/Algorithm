import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int result = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                right = mid;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int result = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 토큰을 하나씩 가져와 정수형 변환
        int n = Integer.parseInt(br.readLine());
        int[] findTo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            findTo[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(findTo);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st2.nextToken());
            int count = upperBound(findTo, target) - lowerBound(findTo, target);
            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }
}
