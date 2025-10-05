import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static int maxSheep;
    static int[] infomation;
    
    public int solution(int[] info, int[][] edges) {
        infomation = info;
        int n = infomation.length;
        graph = new ArrayList[n];
        
        // 그래프 초기화
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }
        List<Integer> next = new ArrayList<>();
        next.add(0);
        
        dfs(0, 0, 0, next);
        
        return maxSheep;
    }
    
    static public void dfs(int node, int sheep,
                           int wolf, List<Integer> nextNodes){
        if(infomation[node] == 0)
            sheep++;
        else wolf++;
        
        if(sheep <= wolf)
            return;
        
        maxSheep = Math.max(sheep, maxSheep);
        
        List<Integer> candidates = new ArrayList<>(nextNodes);
        candidates.remove(Integer.valueOf(node)); // 방문 노드 삭제
        candidates.addAll(graph[node]);
        
        for(int next : candidates){
            dfs(next, sheep, wolf, new ArrayList<>(candidates));
        }
        
    }
}