/* 리팩토링 전 */
/*
class Solution {
    public int solution(int left, int right) {
        int[] temp = new int[right-left+1];
        int tmpIndex = 0;

        for(int i = left; i <= right; i++) temp[tmpIndex++] = i;

        int[] cnt = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            for(int j = 1; j <=right; j++) {
                if(temp[i] % j == 0) cnt[i]++;
            }
        }

        int answer = 0;
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] % 2 == 0) answer += temp[i];
            else answer -= temp[i];
        }
        return answer;
    }
}
*/

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            // 제곱수면 약수의 개수가 홀수
            if(i % Math.sqrt(i) == 0) answer -= i;
                // 제곱수면 약수의 개수가 짝수
            else answer += i;
        }
        return answer;
    }
}