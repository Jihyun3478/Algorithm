import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        
        // B가 이길 수 있는 출전 순서를 구해야 함
        // 이 순서의 경우의 수를 다 구해서 승점이 가장 높은 걸 구하자
        int indexA = 0, indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                answer++;
                indexA++;
                indexB++;
            } else {
                indexB++;
            }
        }
        
        return answer;
    }
}
