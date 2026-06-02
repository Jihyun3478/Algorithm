class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int index = 0; index < s.length(); index++) {
            char oneLetter = s.charAt(index);
            
            if (oneLetter >= 'A' && oneLetter <= 'Z') {
                answer += (char) (((oneLetter - 'A') + n) % 26 + 'A');
            } else if ((oneLetter >= 'a' && oneLetter <= 'z')) {
                answer += (char) (((oneLetter - 'a') + n) % 26 + 'a');
            } else {
                answer += String.valueOf(oneLetter);
            }
        }
        // ((현재문자 - 'a') + n) % 26 + 'a'
        return answer;
    }
}