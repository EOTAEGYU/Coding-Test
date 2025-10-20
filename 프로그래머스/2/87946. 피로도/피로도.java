class Solution {
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return max;
    }
    
    public void dfs(int k, int[][] dungeons, int cnt){
        max = Math.max(max, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            int need = dungeons[i][0];
            int use = dungeons[i][1];
            
            if(!visited[i] && k >= need){
                visited[i] = true;
                dfs(k - use, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}