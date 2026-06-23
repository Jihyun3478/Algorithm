import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int score1 = 0, score2 = 0, score3 = 0;
        List<Integer> answer = new ArrayList<>();
        
        // 패턴 3개를 배열로 정의
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // answers를 순회하면서 각 수포자 점수 카운팅 (i % pattern.length 활용)
        for (int index = 0; index < answers.length; index++) {
            if (answers[index] == pattern1[index % pattern1.length]) {
                score1++;
            }
            if (answers[index] == pattern2[index % pattern2.length]) {
                score2++;
            }
            if (answers[index] == pattern3[index % pattern3.length]) {
                score3++;
            }
        }
        
        // 최고 점수 구하기
        int maxScore = Math.max(score1, Math.max(score2, score3));
        
        // 최고 점수인 수포자 번호를 리스트에 담아 반환
        if (score1 == maxScore) {
            answer.add(1);
        }
        if (score2 == maxScore) {
            answer.add(2);
        }
        if (score3 == maxScore) {
            answer.add(3);
        }
        
        return answer.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}