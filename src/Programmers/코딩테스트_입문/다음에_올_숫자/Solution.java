package Programmers.코딩테스트_입문.다음에_올_숫자;

class Solution {
    public int solution(int[] common) {
        if(common[1] - common[0] == common[2] - common[1]) {
            return common[common.length-1] + (common[1] - common[0]);
        }
        else {
            return common[common.length-1] * (common[2] / common[1]);
        }
    }
}