import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 열흘 간 정현이가 원하는 제품을 모두 살 수 있을 때, answer+1
        // discount 목록을 10개씩만 읽어서, want와 number가 일치할 때 카운팅
        // Map을 사용해야할까? 아니면 Stack?
        // 10개씩 어떻게 자르지? substring? list 복제?
        
        Map<String, Integer> wants = new HashMap<>();
        for (int index = 0; index < want.length; index++) {
            wants.put(want[index], number[index]);
        }
        
        for (int i = 0; discount.length - i >= 10; i++) {
            
            Map<String, Integer> check = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                check.put(discount[j], check.getOrDefault(discount[j], 0) + 1);
            
                if (wants.equals(check)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
