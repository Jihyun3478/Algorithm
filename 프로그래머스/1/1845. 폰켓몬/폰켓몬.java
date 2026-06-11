import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 3, 1, 2, 3
        // {3, 1} {3, 2} {3, 3} {1, 2} {1, 3} {2, 3}
        Set<Integer> set = new HashSet<>();        
        for (int number : nums) {
            set.add(number);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}