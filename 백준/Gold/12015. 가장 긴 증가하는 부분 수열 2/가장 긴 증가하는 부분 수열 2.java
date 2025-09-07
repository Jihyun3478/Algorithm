import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 크기와 수열 입력 받기
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 증가하는 부분 수열 구하기
        List<Integer> tails = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (tails.isEmpty()) {
                tails.add(numbers[0]);
            }

            int left = 0;
            int right = tails.size() - 1;
            int pos = tails.size();
            while (left <= right) {
                int mid = (left + right) / 2;

                if (tails.get(mid) >= numbers[i]) {
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (pos == tails.size()) {
                tails.add(numbers[i]);
            } else {
                tails.set(pos, numbers[i]);
            }
        }

        // 증가하는 부분 수열의 길이 출력
        bw.write(String.valueOf(tails.size()));
        bw.flush();
    }
}
