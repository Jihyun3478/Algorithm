package Programmers.코딩테스트_입문.로그인_성공;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String ID = id_pw[0];
        String PW = id_pw[1];

        for(int i = 0; i < db.length; i++) {
            if(ID.equals(db[i][0])) {
                if(PW.equals(db[i][1])) {
                    return "login";
                }
                else {
                    return "wrong pw";
                }
            }
        }
        return "fail";
    }
}