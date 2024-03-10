package 토스.멋쟁이숫자;

public class Solution {
    public static void main(String[] args) {
        System.out.println("예시 1 답 : " + solution("12223"));
        System.out.println("예시 2 답 : " + solution("111999333"));
        System.out.println("예시 3 답 : " + solution("123"));
    }

    public static int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = -1;

        for(int i = 0; i < s.length()-2; i++) {
            if((arr[i] == arr[i+1]) && (arr[i+1] == arr[i+2])) {
                answer = Math.max(answer, Integer.parseInt(s.substring(i, i+3)));
            }
        }
        return answer;
    }
}