package Programmers.코딩_기초_트레이닝.문자열_겹쳐쓰기;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int len1 = overwrite_string.length();
        int len2 = my_string.length();

        String answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s+len1, len2);
        return answer;
    }
}