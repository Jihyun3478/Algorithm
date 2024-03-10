package Programmers.코딩테스트_입문.A로_B_만들기;

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] beforeChar = before.toCharArray();
        char[] afterChar = after.toCharArray();

        Arrays.sort(beforeChar);
        Arrays.sort(afterChar);

        String b = new String(beforeChar);
        String a = new String(afterChar);

        if(b.equals(a)) {
            return 1;
        }
        else {
            return 0;
        }

    }
}