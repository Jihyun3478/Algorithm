import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y+1];
        
        queue.add(x);
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                
                // 여기서 cur+n, cur*2, cur*3 시도
                // 하나는 범위, 하나는 중복 방문 방지
                if (cur == y) {
                    return answer;
                }
                
                if (cur + n <= y && visited[cur + n] == false) {
                    queue.add(cur + n);
                    visited[cur + n] = true;
                }
                if (cur * 2 <= y && visited[cur * 2] == false) {
                    queue.add(cur * 2);
                    visited[cur * 2] = true;
                }
                if (cur * 3 <= y && visited[cur * 3] == false) {
                    queue.add(cur * 3);
                    visited[cur * 3] = true;
                }
            }
            answer++;
        }
        return -1;
    }
}