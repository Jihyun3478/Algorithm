import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[computers.length];
        
        int networkCnt = 0;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            
            while (!queue.isEmpty()) {
                int temp = queue.poll();
            
                for (int j = 0; j < n; j++) {
                    if (computers[temp][j] == 1 && visited[j] == false) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            networkCnt++;
        }
        return networkCnt;
    }
}
