package Programmers.코딩_기초_트레이닝.문자열_곱하기;

/*
리팩토링 전
*/
//class Solution {
//    public String solution(String my_string, int k) {
//        String answer = "";
//
//        for(int i = 0; i < k; i++) {
//            answer += my_string;
//        }
//        return answer;
//    }
//}

/*
리팩토링 후
*/
class Solution {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < k; i++) {
            sb.append(my_string);
        }
        return sb.toString();
    }
}