import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N과 N줄의 그림 입력받기
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // 적록색약이 아닌 사람이 봤을 때의 구역 개수 구하기
        int sectorCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(board, i, j);
                    sectorCnt++;
                }
            }
        }

        // 적록색약인 사람이 봤을 때의 구역 개수 구하기
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        String[][] newBoard = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = board[i][j];
                if (board[i][j].equals("G")) {
                    newBoard[i][j] = "R";
                }
            }
        }

        int newSectorCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(newBoard, i, j);
                    newSectorCnt++;
                }
            }
        }

        // 2개의 개수 출력하기
        bw.write(sectorCnt + " " + newSectorCnt);
        bw.flush();
    }

    private static void dfs(String[][] board, int i, int j) {
        visited[i][j] = true;
        String color = board[i][j];

        for (int k = 0; k < 4; k++) {
            int currentY = i + dy[k];
            int currentX = j + dx[k];

            if (currentY >= 0 && currentY < board[0].length && currentX >= 0 && currentX < board[0].length) {
                if (!visited[currentY][currentX] && board[currentY][currentX].equals(color)) {
                    dfs(board, currentY, currentX);
                }
            }
        }
    }
}
