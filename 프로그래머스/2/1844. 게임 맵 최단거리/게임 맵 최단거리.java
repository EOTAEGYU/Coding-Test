import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length; // y
        int m = maps[0].length; // x
        
        
        boolean[][] visited = new boolean[n][m];

        return bfs(maps, visited, n, m);
    }
    
    private int bfs(int[][] maps, boolean[][] visited, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            
            if(cx == m-1 && cy == n-1){
                return maps[n-1][m-1];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            
                // 상하좌우 이동하면서 거리 +
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(!visited[ny][nx] && maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        maps[ny][nx] = maps[cy][cx] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }    
        }
        
        return -1;
    }
}