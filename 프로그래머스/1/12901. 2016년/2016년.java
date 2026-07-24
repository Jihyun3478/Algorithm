import java.util.*;

class Solution {
    public String solution(int a, int b) {
        // a월에 해당하는 startOfMonth부터 시작해, b일이 될 때까지 weekOfDays를 계속 순회한다.
        int[] endDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] startOfMonth = {"FRI", "MON", "TUE", "FRI", "SUN", "WED", "FRI", "MON", "THU", "SAT", "TUE", "THU"};
        String[] weekOfDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        int totalDays = 0;
        for (int index = 0; index < a - 1; index++) {
            totalDays += endDays[index];
        }
        totalDays += b - 1;
        
        return weekOfDays[(totalDays + 5) % 7];
    }
}