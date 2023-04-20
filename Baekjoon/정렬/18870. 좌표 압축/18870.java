import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // 원본 배열
        int[] sortArr = new int[N]; // 정렬 후 배열
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백 기준으로 입력을 읽어옴
        for(int i = 0; i < N; i++) {
            arr[i] = sortArr[i] = Integer.parseInt(st.nextToken()); // 두 배열에 입력된 값을 넣어줌
        }
        Arrays.sort(sortArr); // 오름차순 정렬

        int rank = 0;
        for(int k : sortArr) {
            if(!map.containsKey(k)) { // map에 해당 키 값이 중복되지 않을 경우만
                map.put(k, rank); // ex) { -10=0, -9=1, 2=2, 4=3 }
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : arr) { // 2 4 -10 4 -9
            int ranking = map.get(key); // key 값에 대한 value
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}