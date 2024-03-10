package Programmers.코딩_기초_트레이닝.두_수의_연산값_비교하기;

/*
리팩토링 전
*/
//class Solution {
//    public int solution(int a, int b) {
//        String answer = String.valueOf(a) + String.valueOf(b);
//
//        if(Integer.parseInt(answer) == 2*a*b) {
//            return Integer.parseInt(answer);
//        }
//        return Math.max(Integer.parseInt(answer), 2*a*b);
//    }
//}

/*
리팩토링 후
*/
class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt(String.valueOf(a) + String.valueOf(b)), 2*a*b);
    }
}