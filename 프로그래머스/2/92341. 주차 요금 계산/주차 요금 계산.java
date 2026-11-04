import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {      
        // 입차된 이후 출차 내역이 없으면, 23:59에 출차한 것으로 간주
        // fees[0]분에 기본 요금 fees[1]원, fees[2]분당 fees[3]원 추가
        // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림
        // 차량 번호가 작은 자동차부터 청구할 주차 요금 차례대로 리턴
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> total = new TreeMap<>();
        
        for (String record : records) {
            String[] splits = record.split(" ");
            String[] time = splits[0].split(":");
            int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if (splits[2].equals("IN")) {
                inTime.put(splits[1], minutes);
            } else {
                total.merge(splits[1], minutes - inTime.remove(splits[1]), Integer::sum);
            }
        }
        
        for (Map.Entry<String, Integer> entry : inTime.entrySet()) {
            total.merge(entry.getKey(), 23 * 60 + 59 - entry.getValue(), Integer::sum);
        }
        
        int[] answer = new int[total.size()];
        int index = 0;
        for (int time : total.values()) {
            int fee = fees[1];
            if (time > fees[0]) {
                fee += (time - fees[0] + fees[2] - 1) / fees[2] * fees[3];
            }
            answer[index++] = fee;
        }
        
        return answer;
    }
}
