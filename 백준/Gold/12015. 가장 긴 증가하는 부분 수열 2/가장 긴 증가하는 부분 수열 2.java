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

        // 수열의 크기와 수열 입력 받기
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] LIS = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 초기 값으로 첫 번째 수열의 값을 가짐
        LIS[0] = A[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = A[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해줌
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            } else {
                // Lower Bound 이분탐색
                int left = 0;
                int right = lengthOfLIS;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (LIS[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // left가 LIS에서 대치될 원소의 위치가 됨
                // 해당 위치에 key 값으로 원소를 바꿔줌
                LIS[left] = key;
            }
        }

        // 증가하는 부분 수열의 길이 출력
        bw.write(String.valueOf(lengthOfLIS));
        bw.flush();
    }
}

