class Solution {
    public String solution(String phone_number) {
        int size = phone_number.length();
        
        String frontNumber = phone_number.substring(0, size - 4);
        String replaceFrontNumber = frontNumber.replaceAll("[0-9]", "*");
        String lastNumber = phone_number.substring(size - 4);
        
        System.out.println(replaceFrontNumber);
        System.out.println(lastNumber);
        
        return replaceFrontNumber + lastNumber;
    }
}