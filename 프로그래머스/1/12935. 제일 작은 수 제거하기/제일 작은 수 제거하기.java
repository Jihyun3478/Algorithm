import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = list.stream().min(Comparator.naturalOrder()).get();
        list.remove(Integer.valueOf(min));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}