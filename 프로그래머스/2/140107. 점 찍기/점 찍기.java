import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long yIndex = d / k;
        
        for (long i = 0; i <= d / k; i++) {
            long x = (long) i * k;
            while (yIndex >= 0 && x * x + (yIndex * k) * (yIndex*k) > (long) d*d) {
                yIndex--;
            }
            answer += yIndex + 1;
        }
        return answer;
    }
}