class Solution {
    public int solution(String A, String B) {
        int cnt = 0;

        String a = A;
        for(int i = 0; i < A.length(); i++) {
            if(a.equals(B)) {
                return cnt;
            }
            String temp = a.substring(a.length()-1);
            a = temp + a.substring(0, a.length()-1);
            cnt++;
        }
        return -1;
    }
}