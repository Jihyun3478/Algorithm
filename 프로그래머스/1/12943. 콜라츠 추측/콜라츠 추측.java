class Solution {
    public int solution(long num) {
        // 입력된 수가 짝수라면 2로 나눔
        // 입력된 수가 홀수라면 3을 곱하고 1을 더함
        // 결과로 나온 수에 같은 작업을 1이 될 때까지 반복함
        int count = 0;
            
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
            
            if (count == 500) {
                return -1;
            }
        }
        return count;
    }
}