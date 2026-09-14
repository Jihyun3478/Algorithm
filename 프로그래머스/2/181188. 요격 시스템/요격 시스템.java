import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 발사된 미사일은 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격할 수 있음
        // 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없음
        // 요격 미사일은 실수인 x 좌표에서도 발사할 수 있음
        // -> 폭격 미사일(개구간)을 관통하는 최소 요격 개수를 구해야 함
        
        // targets를 e순으로 정렬한다?
        Arrays.sort(targets, (t1, t2) -> {
            return t1[1] - t2[1];
        });
        
        // 겹치는 구간이 있는지 찾고 카운트한다?
        // 최소 개수를 어떻게 보장하지?
        int lastShot = 0;
        for (int index = 0; index < targets.length; index++) {
            if (targets[index][0] >= lastShot) {
                answer++;
                lastShot = targets[index][1];
            }
        }
        
        return answer;
    }
}
