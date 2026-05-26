class Solution {
    public int solution(int[] a, int[] b) {
        int sum = 0;
        
        for (int index = 0; index < a.length; index++) {
            sum += a[index] * b[index];
        }
        
        return sum;
    }
}