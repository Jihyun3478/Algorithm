import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();
        int last = -1;

        for(int i : arr) {
            if(last != i)  {
                list.add(i);
                last = i;
            }
            continue;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}