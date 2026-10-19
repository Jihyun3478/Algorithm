import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> newQueue1 = new LinkedList<>();
        for (int number : queue1) {
            newQueue1.add(number);
        }
        Queue<Integer> newQueue2 = new LinkedList<>();
        for (int number : queue2) {
            newQueue2.add(number);
        }
        
        long sum1 = sum(newQueue1);
        long sum2 = sum(newQueue2);
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int limit = (queue1.length + queue2.length) * 2;
        // while 문 종료 조건?
        while (true) {
            // 크기를 비교해서 작은쪽에 밀어넣기
            if (sum1 > sum2) {
                int temp = newQueue1.poll();
                sum1 = sum1 - temp;
                newQueue2.add(temp);
                sum2 = sum2 + temp;
                answer++;
            } else if (sum1 < sum2) {
                int temp = newQueue2.poll();
                sum2 = sum2 - temp;
                newQueue1.add(temp);
                sum1 = sum1 + temp;
                answer++;
            }
            
            if (sum1 == sum2 || answer > limit) {
                break;
            }
        }
        
        // 같아지지 않으면 -1 리턴
        if (sum1 == sum2) {
            return answer;
        } else {
            return -1;
        }
    }
    
    private long sum(Queue<Integer> queue) {
        long sum = 0;
        for (int number : queue) {
            sum += number;
        }
        return sum;
    }
}