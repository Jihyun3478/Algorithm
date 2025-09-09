import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //   0 1 2
        // 0 o o o
        // 1 o o o
        // 2 o o o
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 공간의 크기 입력 N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 줄에 공간의 상태 입력 받기
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int node = Integer.parseInt(st.nextToken());

                if (node == 1) {
                    distance[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 8; i++) {
                int currentY = y + dy[i];
                int currentX = x + dx[i];

                if (currentY >= 0 && currentY < N && currentX >= 0 && currentX < M) {
                    if (distance[currentY][currentX] == -1) {
                        distance[currentY][currentX] = distance[y][x] + 1;
                        queue.add(new int[] {currentY, currentX});
                    }
                }
            }
        }

        // 안전 거리의 최댓값 출력하기
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int current = distance[i][j];
                max = Math.max(current, max);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
