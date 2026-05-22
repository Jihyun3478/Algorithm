class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int index = 1; index < n; index++) {
            if (n % index == 1) {
                answer = index;
                break;
            }
        }
        return answer;
    }
}