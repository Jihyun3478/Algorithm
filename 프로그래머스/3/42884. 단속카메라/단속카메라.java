import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (r1, r2) -> {
            return r1[1] - r2[1];
        });
        
        int lastShot = Integer.MIN_VALUE;
        for (int index = 0; index < routes.length; index++) {
            if (routes[index][0] > lastShot) {
                answer++;
                lastShot = routes[index][1];
            }
        }
        
        return answer;
    }
}
