import java.util.*;

// <깊이 우선 탐색>
// 1. 현재 노드 방문 처리
// 2. 연결된 노드 중 방문 안 한 것 재귀 호출
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int networkCnt = 0;
    
        for (int index = 0; index < computers.length; index++) {
            if (!visited[index]) {
                dfs(index, computers, visited);
                networkCnt++;
            }
        }
        return networkCnt;
    }
    
    public static void dfs(int current, int[][] computers, boolean[] visited) {
        // 1. 현재 노드 방문 처리
        visited[current] = true;
        
        // 2. 연결된 노드 중 방문 안 한 것 재귀 호출
        for (int index = 0; index < computers.length; index++) {
            if (computers[current][index] == 1 && !visited[index]) {
                dfs(index, computers, visited);
            }
        }
    }
}

// Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[computers.length];
        
//         int networkCnt = 0;
//         for (int i = 0; i < computers.length; i++) {
//             if (visited[i] == true) {
//                 continue;
//             }
//             queue.add(i);
//             visited[i] = true;
            
//             while (!queue.isEmpty()) {
//                 int temp = queue.poll();
            
//                 for (int j = 0; j < n; j++) {
//                     if (computers[temp][j] == 1 && visited[j] == false) {
//                         queue.add(j);
//                         visited[j] = true;
//                     }
//                 }
//             }
//             networkCnt++;
//         }
//         return networkCnt;
