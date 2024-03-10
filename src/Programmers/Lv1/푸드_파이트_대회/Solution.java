package Programmers.Lv1.푸드_파이트_대회;

class Solution {
    public String solution(int[] food) {
        String temp = "";

        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i]/2; j++) {
                temp += i;
            }
        }

        StringBuffer sb = new StringBuffer(temp);
        String reverse = sb.reverse().toString();
        String answer = temp + "0" + reverse;
        return answer;
    }
}