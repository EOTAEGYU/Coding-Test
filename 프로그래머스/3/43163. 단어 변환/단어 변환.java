import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> visited = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            visited.put(words[i], 0);
        }
        
        visited.put(begin, 0);
        
        int answer = bfs(begin, target, words, visited);
        return answer;
    }
    
    private static int bfs(String begin, String target, 
                           String[] words, Map<String, Integer> visited){
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            int currentDist = visited.get(cur);
            
            // 타겟과 일치하면 현재까지 횟수 반환
            if(cur.equals(target)){
                return currentDist;
            }
            
            for(int i = 0; i < words.length; i++){
                // 아직 방문하지 않은 단어
                if(visited.get(words[i]) == 0){
                    int difWord = 0;
                    
                    for(int j = 0; j < cur.length(); j++){
                        if(cur.charAt(j) != words[i].charAt(j)){
                            difWord++;
                        }
                    }

                    // 단어 하나 차이 나면
                    if(difWord == 1){
                        q.add(words[i]);
                        visited.put(words[i], currentDist + 1);
                    } 
                }
            }
        }
        
        return 0;
    }
}