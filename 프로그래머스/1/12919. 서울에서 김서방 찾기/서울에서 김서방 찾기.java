class Solution {
    public String solution(String[] seoul) {
        int location = 0;
        
        for (int index = 0; index < seoul.length; index++) {
            if (seoul[index].equals("Kim")) {
                location = index;
                break;
            }
        }
        return "김서방은 " + location + "에 있다";
    }
}