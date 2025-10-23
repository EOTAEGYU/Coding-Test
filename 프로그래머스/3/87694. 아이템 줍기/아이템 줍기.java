import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        
        // 테두리 표시를 위해 두배로 늘림
        for(int[] r : rectangle){
            for(int i = 0; i < 4; i++){
                r[i] *= 2;
            }
        }
        
        for(int[] r : rectangle){
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];

            // 내부 포함 전체를 2로 채움
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = 2;
                }
            }
            
            // 테두리 1로 표시
            for(int x = x1; x <= x2; x++){
                map[y1][x] = 1;
                map[y2][x] = 1;
            }
            
            for(int y = y1; y <= y2; y++){
                map[y][x1] = 1;
                map[y][x2] = 1;
            }
        }
        
        // 2로 다시 내부 덥기
        for (int[] r : rectangle) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    map[y][x] = 2;
                }
            }
        }

        
        int answer = bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }
    
    public int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean[][] visited = new boolean[101][101];
        visited[characterY][characterX] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});
        int dist = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            dist = cur[2];    
            
            if(x == itemX && y == itemY){
                return dist/2;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
    
    

}