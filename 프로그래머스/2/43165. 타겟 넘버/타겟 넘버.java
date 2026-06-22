import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if (temp[1] == numbers.length) {
                if (temp[0] == target) {
                    answer++;
                }
                continue;
            }
            
            queue.add(new int[]{temp[0] + numbers[temp[1]], temp[1] + 1});
            queue.add(new int[]{temp[0] - numbers[temp[1]], temp[1] + 1});
        }
        return answer;
    }
}




// Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[]{0, 0});
        
//         int answer = 0;
//         while(!queue.isEmpty()) {
//             int[] temp = queue.poll();
            
//             if (temp[1] == numbers.length) {
//                 if (temp[0] == target) {
//                     answer++;
//                 }
//                 continue;
//             }
            
//             queue.add(new int[]{temp[0] + numbers[temp[1]], temp[1] + 1});
//             queue.add(new int[]{temp[0] - numbers[temp[1]], temp[1] + 1});
//         }
//         return answer;