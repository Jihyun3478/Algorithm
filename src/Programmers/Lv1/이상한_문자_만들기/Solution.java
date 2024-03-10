package Programmers.Lv1.이상한_문자_만들기;

class Solution {
    public String solution(String s) {
        String[] strArr = s.split("");
        String answer = "";
        int cnt = 0;

        for(String str : strArr) {
            if(str.contains(" ")) cnt = 0;
            else cnt++;

            if(cnt % 2 == 0) answer += str.toLowerCase();
            else answer += str.toUpperCase();
        }
        return answer;
    }
}