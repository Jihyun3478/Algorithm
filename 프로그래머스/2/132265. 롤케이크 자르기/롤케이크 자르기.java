import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 각 조각에 동일한 가짓수의 토핑이 올라가면, 공평하게 롤케이크가 나누어진 것으로 생각
        // 롤케이크를 공평하게 자르는 방법의 수
        // 배열을 잘랐을 때, 중복을 제거한 좌우의 토핑 수가 같으면 카운트
        
//         String temp = "";
//         for (int index = 0; index < topping.length; index++) {
//             temp += String.valueOf(topping[index]);
//         }
        
//         int answer = 0;
//         for (int index = 1; index < topping.length; index++) {
//             String left = temp.substring(0, index);
//             String right = temp.substring(index, temp.length());
            
//             Set<String> uniqueLeft = new HashSet<>(Arrays.asList(left.split("")));
//             Set<String> uniqueRight = new HashSet<>(Arrays.asList(right.split("")));
                                                     
//             if (uniqueLeft.size() == uniqueRight.size()) {
//                 answer++;
//             }
//         }
//         return answer;
        
        int[] rightCount = new int[1000000];
        Set<Integer> uniqueLeft = new HashSet<>();
        Set<Integer> uniqueRight = new HashSet<>();
        for (int index = 0; index < topping.length; index++) {
            rightCount[topping[index]]++; // rightCount의 인덱스에 해당하는 토핑의 개수 증가
            uniqueRight.add(topping[index]);
        }
        
        int answer = 0;
        for (int index = 1; index < topping.length; index++) {
            rightCount[topping[index - 1]]--;
            if (rightCount[topping[index - 1]] == 0) {
                uniqueRight.remove(topping[index - 1]);
            }
            uniqueLeft.add(topping[index - 1]);
            
            if (uniqueLeft.size() == uniqueRight.size()) {
                answer++;
            }
        }
        return answer;
    }
}
