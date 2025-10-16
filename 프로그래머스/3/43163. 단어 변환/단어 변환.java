import java.util.*;

class Solution {
    static class Word {
        String str;
        int depth;
        Word(String str, int depth){
            this.str = str;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
         // target이 words 안에 없으면 변환 불가
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        return bfs(begin, target, words);
    }
    
    static public int bfs(String begin, String target, String[] words){
        int n = words.length;
        int wordLen = words[0].length();
        boolean[] visited = new boolean[n];
        
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            if(cur.str.equals(target)){
                return cur.depth;
            }
            
            for(int i = 0; i < n; i++){
                if(visited[i]) continue;
                
                int notSame = 0;
                for(int j = 0; j < wordLen; j++){ // 같은 않은 글자 카운트
                    if(cur.str.charAt(j) != words[i].charAt(j)){
                        notSame++;
                    }
                    if(notSame > 1){
                        break;
                    }
                }
                // 같지 않은 글자가 한개고 방문하지 않았으면 q에 추가
                if(notSame == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(new Word(words[i], cur.depth + 1));
                }
                
            }
        }
        return 0;
    }

}