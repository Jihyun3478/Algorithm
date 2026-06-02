/* 
<너비 우선 탐색>
1. 큐에서 빼고 확인
2. 도착인지 확인
3-1. no -> 연결된 노드 큐에 넣기
3-2. yes -> 끝
*/

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
            
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for (int index = 0; index < 4; index++) {
                int newX = temp[0] + dx[index];
                int newY = temp[1] + dy[index];
                
                // 갈 수 있는지 확인
                if (newX >= 0 && newX < maps.length
                   && newY >= 0 && newY < maps[0].length
                   && maps[newX][newY] == 1
                   && visited[newX][newY] == false) {
                    queue.add(new int[]{newX, newY, temp[2] + 1});
                    visited[newX][newY] = true;
                }
                
                // 도착 확인
                if (newX == maps.length-1 && newY == maps[0].length-1) {
                    return temp[2] + 1;
                }
            }
        }
        return -1;
    }
}