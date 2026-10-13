import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        // 2차원 배열로 변경
        String[][] newMap = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                newMap[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!newMap[i][j].equals("X") && visited[i][j] == false) {
                    int sum = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        sum += Integer.parseInt(newMap[temp[0]][temp[1]]);
                        
                        for (int index = 0; index < 4; index++) {
                            int newX = temp[0] + dx[index];
                            int newY = temp[1] + dy[index];
                            
                            if (newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length() && !newMap[newX][newY].equals("X") && visited[newX][newY] == false) {
                                queue.add(new int[]{newX, newY});
                                visited[newX][newY] = true;
                            }
                        }
                    }
                    result.add(sum);
                }
            }
        }
        
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}