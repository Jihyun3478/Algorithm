package Programmers.Lv1.문자열_다루기_기본;

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            s = s.replaceAll("[aA-zZ]", "*");
            if(!s.contains("*")) return true;
            else return false;
        }
        return false;
    }
}