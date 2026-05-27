class Solution {
    public long solution(int price, int myMoney, int count) {
        long totalPrice = 0;
        
        for (int index = 1; index <= count; index++) {
            totalPrice += price * index;
        }
        
        if (myMoney - totalPrice > 0) {
            return 0;
        }
        return Math.abs(myMoney - totalPrice);
    }
}