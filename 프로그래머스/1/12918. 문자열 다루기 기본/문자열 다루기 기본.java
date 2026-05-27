import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        boolean isNumber = Pattern.matches("^[0-9]*$", s);
        
        if (isNumber && (s.length() == 4 || s.length() == 6)) {
            return true;
        }
        return false;
    }
}