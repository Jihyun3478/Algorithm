import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        //   A B C
        // A 1 1 0
        // B 1 1 0
        // C 0 0 1
        //    A
        //  /
        // B     C
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[computers.length];
        
        int networkCnt = 0;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            queue.add(i);
            
            networkCnt++;
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                
                for (int j = 0; j < n; j++) {
                    if (computers[temp][j] == 1 && visited[j] == false) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        return networkCnt;
    }
}