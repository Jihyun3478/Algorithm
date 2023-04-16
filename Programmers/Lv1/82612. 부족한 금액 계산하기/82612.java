class Solution {
    public long solution(int price, int myMoney, int count) {
        long payMoney = 0;

        for(int i = 1; i <= count; i++) {
            payMoney += price*i;
        }

        if(myMoney >= payMoney) return 0;
        return payMoney - myMoney;
    }
}