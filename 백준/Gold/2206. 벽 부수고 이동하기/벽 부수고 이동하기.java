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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N과 M, N x M 행렬 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};

        // (1, 1)에서 (N, M)까지 이동할 수 있는 최단 경로 구하기
        // 이 때 이동할 수 없는 벽인 1인 곳을 한 개까지만 부수고 이동할 수 있음
        int[][] map = new int[N][M];
        int[][][] distance = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                distance[i][j][0] = -1;
                distance[i][j][1] = -1;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 0});

        // 시작점이 벽일 경우
        if (map[0][0] == 1) {
            distance[0][0][1] = 1;
            queue.add(new int[] {0, 0, 1});
        } else {
            distance[0][0][0] = 1;
            queue.add(new int[] {0, 0, 0});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int broken = current[2];

            for (int i = 0; i < 4; i++) {
                int currentY = y + dy[i];
                int currentX = x + dx[i];

                if (currentY >= 0 && currentY < N && currentX >= 0 && currentX < M) {
                    if (map[currentY][currentX] == 0 && distance[currentY][currentX][broken] == -1) {
                        distance[currentY][currentX][broken] = distance[y][x][broken] + 1;
                        queue.add(new int[] {currentY, currentX, broken});

                    } else if (map[currentY][currentX] == 1 && broken == 0 && distance[currentY][currentX][1] == -1) {
                        distance[currentY][currentX][1] = distance[y][x][0] + 1;
                        queue.add(new int[] {currentY, currentX, 1});
                    }
                }
            }
        }

        // 최단 경로 출력, 불가능 할 때는 -1 출력
        int d0 = distance[N - 1][M - 1][0];
        int d1 = distance[N - 1][M - 1][1];
        int answer = 0;
        if (d0 == -1 && d1 == -1) {
            answer = -1;
        } else if (d0 == -1) {
           answer = d1;
        }  else if (d1 == -1) {
            answer = d0;
        } else {
            answer = Math.min(d0, d1);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
