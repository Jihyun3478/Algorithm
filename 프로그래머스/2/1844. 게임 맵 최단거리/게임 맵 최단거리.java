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
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        queue.add(new int[]{0, 0, 1});
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                
                // 갈 수 있을 때
                if (newY >= 0 && newY < maps.length
                   && newX >= 0 && newX < maps[0].length
                   && maps[newY][newX] == 1
                   && visited[newY][newX] == 0) {
                    visited[newY][newX] = 1;
                    queue.add(new int[]{newY, newX, temp[2] + 1});
                }
            
                // 도착
                if (newY == maps.length - 1 && newX == maps[0].length - 1) {
                    return temp[2] + 1;
                }
            }
        }
        return -1;
    }
}