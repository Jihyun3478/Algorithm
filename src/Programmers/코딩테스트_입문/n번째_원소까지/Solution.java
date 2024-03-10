package Programmers.코딩테스트_입문.n번째_원소까지;

/* 리팩토링 전 */
//class Solution {
//    public int[] solution(int[] num_list, int n) {
//        int[] answer = new int[n];
//        return Arrays.copyOf(num_list, n);
//    }
//}

/* 리팩토링 후 */
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = num_list[i];
        }

        return answer;
    }
}