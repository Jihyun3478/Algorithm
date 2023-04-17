class Solution {
    public int solution(int[][] sizes) {
        int MAX = 0, MIN = 0;

        for(int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            MAX = Math.max(MAX, max);
            MIN = Math.max(MIN, min);
        }
        return MAX*MIN;
    }
}