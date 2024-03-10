package Programmers.코딩_기초_트레이닝.길이에_따른_연산;

/*
리팩토링 전
*/
//class Solution {
//    public int solution(int[] num_list) {
//        int length = 0, answer = 1;
//
//        for(int i = 0; i < num_list.length; i++) {
//            length++;
//        }
//
//        if(length >= 11) {
//            for(int i : num_list) {
//                answer += i;
//            }
//            return answer-1;
//        }
//        else {
//            for(int i : num_list) {
//                answer *= i;
//            }
//        }
//        return answer;
//    }
//}

/*
리팩토링 후
*/
class Solution {
    public int solution(int[] num_list) {
        int answer = (num_list.length >= 11 ? 0 : 1);

        for(int i = 0; i < num_list.length; i++) {
            if(num_list.length >= 11) {
                answer += num_list[i];
            }
            else {
                answer *= num_list[i];
            }
        }
        return answer;
    }
}