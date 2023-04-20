import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            else {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]).append('\n');
        for (int i = 1; i < N; i++) {
            // 중복 제외
            if(!strArr[i].equals(strArr[i-1])) {
                sb.append(strArr[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}