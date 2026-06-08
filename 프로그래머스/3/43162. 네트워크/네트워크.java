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
            
                for (int index = 0; index < n; index++) {
                    if (computers[temp][index] == 1 && visited[index] == false) {
                        queue.add(index);
                        visited[index] = true;
                    }
                }
            }
            networkCnt++;
        }
        return networkCnt;
    }
}