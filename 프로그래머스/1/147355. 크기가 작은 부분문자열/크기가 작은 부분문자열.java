class Solution {
    public int solution(String t, String p) {
        int totalCount = t.length() - p.length() + 1;
        long[] temp = new long[totalCount];
        
        for (int index = 0; index < totalCount; index++) {
            String substring = t.substring(index, index + p.length());
            temp[index] = Long.parseLong(substring);
        }
        
        int moreThanCount = 0;
        for (int index = 0; index < temp.length; index++) {
            if (temp[index] <= Long.parseLong(p)) {
                moreThanCount++;
            }
        }
        return moreThanCount;
    }
}