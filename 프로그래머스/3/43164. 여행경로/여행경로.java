import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];      
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        
        Arrays.sort(tickets, (ticket1, ticket2) -> {
            int compare = ticket1[0].compareTo(ticket2[0]);
            if (compare != 0) {
                return compare;
            }
            return ticket1[1].compareTo(ticket2[1]);
        });
        
        dfs("ICN", tickets, answer, visited);
        
        return answer.toArray(new String[0]);
    }
    
    private boolean dfs(String currentAirport, String[][] tickets, List<String> answer, boolean[] visited) {
        if (answer.size() == tickets.length + 1) {
            return true;
        }
        
        for (int index = 0; index < tickets.length; index++) {
            if (currentAirport.equals(tickets[index][0]) && !visited[index]) {
                visited[index] = true;
                answer.add(tickets[index][1]);
                
                if (dfs(tickets[index][1], tickets, answer, visited)) {
                    return true;
                }
                
                answer.remove(answer.size() - 1);
                visited[index] = false;
            }
        }
        return false;
    }
}

// Queue<String[]> queue = new LinkedList<>();
//         queue.add(new String[]{tickets[0][0], tickets[0][1]});
//         boolean[] visited = new boolean[tickets.length];
//         visited[0] = true;
        
//         String[] answer = new String[tickets.length + 1];
//         int index = 0;
//         String last = "";
        
//         while (!queue.isEmpty()) {
//             String[] temp = queue.poll(); // ICN, JFK
            
//             for (int i = 1; i < tickets.length; i++) {
//                 if (temp[1].equals(tickets[i][0]) && !visited[i]) {
//                     queue.add(new String[]{tickets[i][0], tickets[i][1]}); // JFK, HND
//                     visited[i] = true;
//                 }
//             }
            
//             answer[index] = temp[0];
//             last = temp[1];
//             if (index < answer.length - 1) {
//                 index++;
//             }
//         }
//         answer[answer.length - 1] = last;
//         return answer;
