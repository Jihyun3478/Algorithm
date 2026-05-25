import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int sum = 0;
        
        for (int index = 0; index < numbers.length; index++) {
            if (list.contains(numbers[index])) {
                list.remove(Integer.valueOf(numbers[index]));
            }
        }
        
        for (int index = 0; index < list.size(); index++) {
            sum += list.get(index);
        }
        return sum;
    }
}