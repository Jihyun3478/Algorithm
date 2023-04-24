import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(nArr, key) - lowerBound(nArr, key)).append(' ');
        }
        System.out.println(sb);
    }
    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        // low가 high랑 같아질 때까지 반복
        while (low < high) {
            int mid = (low+high)/2; // 중간 위치를 구함

            // key 값이 중간 위치의 값보다 작거나 같을 경우
            if(key <= arr[mid]) {
                high = mid; // 왼쪽으로 탐색
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        // low가 high랑 같아질 때까지 반복
        while(low < high) {
            int mid = (low+high)/2; // 중간위치를 구함

            // key 값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]) {
                high = mid;
            }
            // 중복 원소의 경우 else에서 처리됨
            else {
                low = mid+1;
            }
        }
        return low;
    }
}