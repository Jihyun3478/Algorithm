package Programmers.코딩_기초_트레이닝.더_크게_합치기;

/*
리팩토링 전
*/
//class Solution {
//    public int solution(int a, int b) {
//        String answer1 = String.valueOf(a) + String.valueOf(b);
//        String answer2 = String.valueOf(b) + String.valueOf(a);
//
//        if (Integer.parseInt(answer1) > Integer.parseInt(answer2)) {
//            return Integer.parseInt(answer1);
//        }
//        return Integer.parseInt(answer2);
//    }
//}

/*
리팩토링 후
*/
class Solution {
    public int solution(int a, int b) {
        String answer1 = String.valueOf(a) + String.valueOf(b);
        String answer2 = String.valueOf(b) + String.valueOf(a);

        return Math.max(Integer.parseInt(answer1), Integer.parseInt(answer2));
    }
}