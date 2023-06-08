class Solution {
    public int solution(String t, String p) {
        long p_Long = Long.parseLong(p);
        int cnt = 0;

        for(int i = 0; i <= t.length()-p.length(); i++) {
            String s = t.substring(i, i+p.length());
            System.out.print(s + " ");
            if(Long.parseLong(s) <= p_Long) {
                cnt++;
            }
        }
        return cnt;
    }
}