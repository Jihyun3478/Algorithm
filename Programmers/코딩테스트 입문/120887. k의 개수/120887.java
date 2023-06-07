class Solution {
    public int solution(int i, int j, int k) {
        String s = "";
        String[] strArr = new String[j-i];
        String k_Str = String.valueOf(k);
        int cnt = 0;

        for(int I = i; I <= j; I++) {
            s = String.valueOf(I);
            strArr = s.split("");

            for(int J = 0; J < strArr.length; J++) {
                if(strArr[J].equals(k_Str)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}