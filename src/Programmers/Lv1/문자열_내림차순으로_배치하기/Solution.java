package Programmers.Lv1.문자열_내림차순으로_배치하기;

/* 리팩토링 전 */
/*
import java.util.*;

class 토스.멋쟁이숫자.Solution {
    public String solution(String s) {
        String[] strArr = s.split("");
        Arrays.sort(strArr, Collections.reverseOrder());

        String answer = "";
        for(String i : strArr) {
            answer += i;
        }
        return answer;
    }
}
*/

import java.util.*;

class Solution {
    public String solution(String s) {
        char[] sol = s.toCharArray();

        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
}