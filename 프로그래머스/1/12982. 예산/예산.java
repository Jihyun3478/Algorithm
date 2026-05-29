import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        for (int index = 0; index < d.length; index++) {
            budget -= d[index];
            if (budget < 0) {
                break;
            } else {
                answer = index + 1;
            }
            answer = index + 1;
        }
        return answer;
    }
}