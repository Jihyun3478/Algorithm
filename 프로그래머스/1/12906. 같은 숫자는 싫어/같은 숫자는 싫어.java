import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for (int number : arr) {
            list.add(number);
        }
        
        List<Integer> answer = new ArrayList<>();
        answer.add(list.get(0));
        
        int number = 0;
        for (int i = 1; i < list.size(); i++) {
            number = list.get(i);
                if (number != list.get(i-1)) {
                    answer.add(number);
                }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}