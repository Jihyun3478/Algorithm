class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        
        if (a < b) {
            for (int index = a; index <= b; index++) {
                sum += index;
            }
        } else {
            for (int index = b; index <= a; index++) {
                sum += index;
            }
        }
        
        return sum;
    }
}