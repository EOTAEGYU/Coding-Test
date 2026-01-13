import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int leg = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 지도 탐색 후 섬 번호 매기기
        int count = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i, j, count);
                    count++;
                }
            }
        }

        // 2. 섬의 테두리에서 bfs 탐색 후 가장 가까운 다리 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 근처에 바다가 있으면 bfs
                if(map[i][j] > 1){ // 섬을 의미
                    for(int k = 0; k < 4; k++){
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        // 바다가 있다면 현재 위치에서 bfs
                        if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                            if(map[ny][nx] == 0){
                                bfs(i, j, map[i][j]);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(leg);
    }

    // 섬 구분하기
    static public void dfs(int i, int j, int count){
        visited[i][j] = true;
        map[i][j] = count;

        for(int k = 0; k < 4; k++){
            int nx = j + dx[k];
            int ny = i + dy[k];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    dfs(ny, nx, count);
                }
            }
        }
    }

    // 가장 가까운 섬으로 가는 다리 길이 찾기
    static public void bfs(int i, int j, int island) {
        // 1. visited 초기화 (매번 생성은 성능에 좋지 않음)
        visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j, 0});
        visited[i][j] = true; // 시작점 방문 처리 필수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int curDistance = current[2];

            // 가지치기: 현재 거리가 이미 찾은 최소값보다 크다면 더 볼 필요 없음
            if (curDistance >= leg) return;

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // 다른 섬을 만났을 때
                    if (map[ny][nx] > 0 && map[ny][nx] != island) {
                        leg = Math.min(leg, curDistance);
                        return; // 최단 거리를 찾았으므로 해당 BFS 종료
                    }

                    // 바다이고 방문하지 않았을 때
                    if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx, curDistance + 1});
                    }
                }
            }
        }
    }
}
