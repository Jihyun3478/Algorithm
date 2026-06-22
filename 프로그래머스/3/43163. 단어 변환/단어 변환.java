import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Temp> queue = new LinkedList<>();
        queue.add(new Temp(begin, 0));
        boolean[] visited = new boolean[words.length];
        visited[0] = true;
        
        // words에서 한 글자만 다른 단어가 있다면 그 단어로 체인지
        // 단, 체인지 할 단어가 target과 더 가까워져야 함
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        while (!queue.isEmpty()) {
            Temp temp = queue.poll();
                
            if (temp.word.equals(target)) {
                return temp.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                
                int diffCount = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (temp.word.charAt(j) != words[i].charAt(j)) {
                        diffCount++;
                    }
                }
                
                if (diffCount == 1) {
                    queue.add(new Temp(words[i], temp.count + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}

class Temp {
    String word;
    int count;
    
    public Temp(String word, int count) {
        this.word = word;
        this.count = count;
    }
}