import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        
        for (int index = 0; index < s.length(); index++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(index)));
        }
        return sum;
    }
}