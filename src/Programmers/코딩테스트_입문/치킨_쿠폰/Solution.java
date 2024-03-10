package Programmers.코딩테스트_입문.치킨_쿠폰;

class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int cnt = 0;

        while (coupon >= 10) {
            int remainder = coupon % 10;
            cnt += coupon / 10;
            coupon = remainder + coupon / 10;
        }
        return cnt;
    }
}