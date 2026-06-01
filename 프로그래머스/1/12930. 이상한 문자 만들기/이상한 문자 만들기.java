class Solution {
    public String solution(String s) {
        s = s.toUpperCase();
        // s = s.replaceAll("\\s+", " ");
        // String[] splitS = s.split(" ");
        
        String answer = "";
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            String oneLetter = String.valueOf(s.charAt(i));
            
            if (oneLetter.equals(" ")) {
                answer += oneLetter;
                index = 0;
            } else if (index % 2 == 1) {
                answer += oneLetter.toLowerCase();
                index++;
            } else {
                answer += oneLetter;
                index++;
            }
        }
        return answer;
    }
}