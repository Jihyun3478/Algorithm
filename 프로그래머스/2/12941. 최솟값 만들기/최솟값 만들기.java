import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0, index = 0;
        for (int i = B.length - 1; i >= 0; i--) {
            answer += A[index] * B[i];
            index++;
        }
        
        return answer;
    }
}