/*
class Solution {
    public String solution(String phone_number) {
        String notStar = phone_number.substring(phone_number.length()-4, phone_number.length());
        String star = phone_number.substring(0, phone_number.length()-4);

        star = star.replaceAll("[0-9]", "*");
        return star + notStar;
    }
}
*/

class Solution {
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}