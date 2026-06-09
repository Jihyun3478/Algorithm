import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>();
        for (String card1 : cards1) {
            queue1.add(card1);
        }
        Queue<String> queue2 = new LinkedList<>();
        for (String card2 : cards2) {
            queue2.add(card2);
        }
        String answer = "";
        
        for (int index = 0; index < goal.length; index++) {
            String temp = "";
            if (queue1.contains(goal[index])) {
                temp = queue1.poll();
            } else if (queue2.contains(goal[index])) {
                temp = queue2.poll();
            }
            
            if (temp.equals(goal[index])) {
                answer = "Yes";
            } else {
                answer = "No";
            }
        }
        
        return answer;
    }
}