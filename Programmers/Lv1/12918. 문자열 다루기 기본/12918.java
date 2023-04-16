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