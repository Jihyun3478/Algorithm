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

        // 참가자 수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 티셔츠 사이즈별 신청자 수 입력받기
        int[] applicantCount = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            applicantCount[i] = Integer.parseInt(st.nextToken());
        }

        // 정수 티셔츠 T와 펜의 묶음 수 P 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        // 티셔츠를 T장식 최소 몇 묶음 주문해야하는지
        int bundleTShirt = 0;
        for (int i = 0; i < 6; i++) {
            if (applicantCount[i] > 0 && applicantCount[i] <= T) {
                bundleTShirt++;
            } else if (applicantCount[i] > T) {
                if (applicantCount[i] % T == 0) {
                    bundleTShirt += applicantCount[i] / T;
                } else {
                    bundleTShirt += applicantCount[i] / T + 1;
                }
            } else {
                continue;
            }
        }
        bw.write(bundleTShirt + "\n");

        // 펜을 P자루 씩 최대 몇 묶음 주문할 수 있는지, 그 때 펜을 한 자루씩 몇 개 주문하는지
        int bundlePen = N / P;
        int remainPen = N % P;

        bw.write(bundlePen + " " + remainPen);

        br.close();
        bw.close();
    }
}
