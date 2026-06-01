class Solution {
    public int solution(int[][] sizes) {
        int MAX = 0, MIN = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]); // 60, 70, 60, 80
            int min = Math.min(sizes[i][0], sizes[i][1]); // 50, 30, 30
            
            MAX = Math.max(MAX, max); // 60, 70, 70, 80
            MIN = Math.max(MIN, min); // 50, 50, 50, 50
        }
        return MAX * MIN;
    }
}