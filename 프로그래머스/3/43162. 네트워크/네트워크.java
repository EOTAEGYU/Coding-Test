import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        List<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    list[i].add(j);
                }
            }
            System.out.println(list[i]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(list, visited, i);
                count++;
            }
        }
            
        int answer = count;
        return answer;
    }
    
    private void dfs(List<Integer>[] list, boolean[] visited, int i){
        visited[i] = true;
        for(int next : list[i]){
            if(!visited[next]){
                dfs(list, visited, next);
            }
        }
    }
}