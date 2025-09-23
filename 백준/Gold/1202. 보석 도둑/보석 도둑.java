import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보석의 수, 각 보석의 무게와 가격, 상덕이가 가지고 있는 가방과 각 가방에 담을 수 있는 최대 무게 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewelInfo = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelInfo[i][0] = Integer.parseInt(st.nextToken());
            jewelInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] maxWeight = new int[K];
        for (int i = 0; i < K; i++) {
            maxWeight[i] = Integer.parseInt(br.readLine());
        }

        // 무게 기준 보석 정보 오름차순 정렬
        Arrays.sort(jewelInfo, Comparator.comparingInt((int[] j) -> j[0]));
        // 용량 기준 오름차순 정렬
        Arrays.sort(maxWeight);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            while (index < N && jewelInfo[index][0] <= maxWeight[i]) {
                pq.add(jewelInfo[index][1]);
                index++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
