package Programmers.Lv2.최댓값과_최솟값;

class Solution {
    public String solution(String s) {
        // String 배열로 변환
        // 배열에서 max, min 값 추출
        // 문자열에 담아서 리턴
        String[] str = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            if(min > num) {
                min = num;
            }

            if(max < num) {
                max = num;
            }
        }
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}