import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands[index]에서 i, j, k 꺼내기
        // array에서 i~j 범위 자르기
        // 자른 배열 정렬
        // k번째 값 꺼내기
        for (int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[length];
            
            int index = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp[index] = array[j];
                index++;
            }
            
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
