class Solution {
    public String solution(int n) {
        String[] watermelon = { "수", "박" };
        String answer = "";
        
        for (int index = 0; index < n; index++) {
            if (index % 2 == 0) {
                answer += watermelon[0];
            } else {
                answer += watermelon[1];
            }
        }
        return answer;
    }
}