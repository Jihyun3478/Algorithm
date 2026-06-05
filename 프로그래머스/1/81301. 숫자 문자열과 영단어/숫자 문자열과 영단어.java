class Solution {
    public int solution(String s) {
        String[] numWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int index = 0; index < numWord.length; index++) {
            s = s.replaceAll(numWord[index], index + "");
        }
        return Integer.parseInt(s);
    }
}