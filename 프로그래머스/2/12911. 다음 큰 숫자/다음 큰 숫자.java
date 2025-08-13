import java.util.*;

class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int nCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                nCount++;
            }
        }
        
        int answer = 0;
        while (true) {
            n++;
            binary = Integer.toBinaryString(n);
            int count = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }
            
            if (nCount == count) {
                answer = n;
                break;
            } else {
                continue;
            }
        }
        return answer;
    }
}