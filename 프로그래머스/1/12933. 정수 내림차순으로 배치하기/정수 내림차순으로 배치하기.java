import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        String answer = "";
        for (int index = 0; index < arr.length; index++) {
            answer += arr[index];
        }
        return Long.parseLong(answer);
    }
}