import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static boolean[][] visited;
    static int answer = 0;
    static int maxCell = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        int[][] board = new int[N][M];

        // 보드 입력 (공백으로 구분된 정수)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > maxCell) maxCell = board[i][j]; // 가지치기용 최대값
            }
        }

        // 모든 시작점에서 깊이 4 DFS (+ 'ㅗ' 예외 처리)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(board, i, j, 1, board[i][j]);  // 현재 칸 포함하므로 depth=1
                visited[i][j] = false;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void dfs(int[][] board, int i, int j, int depth, int sum) {
        // 가지치기: 남은 칸이 모두 최대값이라도 현재 answer를 못 넘으면 중단
        if (sum + maxCell * (4 - depth) <= answer) return;

        if (depth == 4) {
            if (sum > answer) answer = sum;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int currentY = i + dy[k];
            int currentX = j + dx[k];

            if (currentY >= 0 && currentY < board.length && currentX >= 0 && currentX < board[0].length) {
                if (!visited[currentY][currentX]) {
                    // 일반 경로 확장
                    visited[currentY][currentX] = true;
                    dfs(board, currentY, currentX, depth + 1, sum + board[currentY][currentX]);
                    visited[currentY][currentX] = false;

                    // 'ㅗ' 모양 처리: depth==2일 때는 현재 위치(i,j)를 고정하고 팔 하나만 더 붙임
                    if (depth == 2) {
                        visited[currentY][currentX] = true;
                        dfs(board, i, j, depth + 1, sum + board[currentY][currentX]); // 위치 고정
                        visited[currentY][currentX] = false;
                    }
                }
            }
        }
    }
}
