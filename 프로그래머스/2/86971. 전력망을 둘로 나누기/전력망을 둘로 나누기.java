import java.util.*;
class Solution {
    public class Tree{
        List<Integer> list = new ArrayList<>();
    }
    
    public int solution(int n, int[][] wires) {
        Tree[] tree = new Tree[n + 1];
        
        for(int i = 0; i <= n; i++){
            tree[i] = new Tree();
        }
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            tree[a].list.add(b);
            tree[b].list.add(a);
        }

        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
        
            tree[a].list.remove(Integer.valueOf(b));
            tree[b].list.remove(Integer.valueOf(a));
            
            int aCount = dfs(tree, a, visited);
            int bCount = dfs(tree, b, visited);
            
            min = Math.min(min, Math.abs(aCount - bCount));
            
            tree[a].list.add(b);
            tree[b].list.add(a);            
        }

        return min;
    }
    
    public int dfs(Tree[] tree, int node, boolean[] visited){
        visited[node] = true;
        int cnt = 1;
        
        for(int next : tree[node].list){
            if(!visited[next]){
               cnt += dfs(tree, next, visited);
            }
        }
        return cnt;
    }
}