import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // k진수 변환
        String number = Integer.toString(n, k);
        
        // 0 기준으로 숫자 추출
        String[] splitNumber = number.split("0");
        
        // 해당 숫자를 10진수로 변환했을 때, 소수인지 판별
        // 소수면 카운팅
        int answer = 0;
        for (int i = 0; i < splitNumber.length; i++) {
            if (!splitNumber[i].equals("")) {
                long temp = Long.parseLong(splitNumber[i]);
                if (temp == 1) {
                    continue;
                }
            
                String decimal = Long.toString(temp, 10);
                long decimalNum = Long.parseLong(decimal);
                if (checkPrimeNumber(decimalNum)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean checkPrimeNumber(long decimalNum) {
        for (int j = 2; j <= Math.sqrt(decimalNum); j++) {
            if (decimalNum % j == 0) {
                return false;
            }
        }
        return true;
    }
}