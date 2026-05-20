import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        
        StringBuilder sb = new StringBuilder(s);
        String reverseS = sb.reverse().toString();
        
        for (int index = 0; index < reverseS.length(); index++) {
            answer[index] = reverseS.charAt(index) - '0';
        }
        return answer;
    }
}