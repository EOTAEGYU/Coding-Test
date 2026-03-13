import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        
        int[] answer = new int[T];
                
        for(int e = 0; e < T; e++){
            int i = commands[e][0];
            int j = commands[e][1];
            int k = commands[e][2];
            
            int[] slice = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(slice);
            
            answer[e] = slice[k-1];
        }
        
        
        
        return answer;
    }
}