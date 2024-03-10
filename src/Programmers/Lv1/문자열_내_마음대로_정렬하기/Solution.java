package Programmers.Lv1.문자열_내_마음대로_정렬하기;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
                else return o1.charAt(n) - o2.charAt(n);
            }
        });
        return strings;
    }
}