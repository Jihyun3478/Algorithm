import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int pointer = 1;
        int gap = 0;
        int answer = 0;

        for (int station : stations) {  // 4
            int left = station - w; // left = 3
            int right = station + w; // right = 5
            
            gap = left - pointer; // gap = 2
            if (gap > 0) {
                answer += (gap + (2 * w + 1) - 1) / (2 * w + 1);
            }
            
            pointer = right + 1; // pointer = 6
        }
        
        if (pointer <= n) {
            gap = (n + 1) - pointer;
            answer += (gap + (2 * w + 1) - 1) / (2 * w + 1);
        }
        
        return answer;
    }
}