import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
        
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            int aCount = dfs(graph, a, visited);
            int bCount = n - aCount;
            
            min = Math.min(min, Math.abs(aCount - bCount));
            
            graph[a].add(b);
            graph[b].add(a);            
        }

        return min;
    }
    
    public int dfs(List<Integer>[] graph, int node, boolean[] visited){
        visited[node] = true;
        int cnt = 1;
        
        for(int next : graph[node]){
            if(!visited[next]){
               cnt += dfs(graph, next, visited);
            }
        }
        return cnt;
    }
}