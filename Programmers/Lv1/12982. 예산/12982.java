import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0, answer = 0;

        for(int i : d) {
            sum += i;

            if(budget >= sum) answer++;
            else if(budget < sum) break;
        }
        return answer;
    }
}