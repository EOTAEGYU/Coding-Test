import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    public static int w;
    public static int h;
    public static boolean[][] visited;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            // 맵 초기화
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int y = 0; y < h; y++){ // 세로 y
                for (int x = 0; x < w; x++){ // 가로 x
                    if(map[y][x] == 1 && !visited[y][x]){
                        count++;
                        dfs(x, y);
                    }
                }
            }
            System.out.println(count);

        }

    }
    public static void dfs(int x, int y){
        // 탐색
        visited[y][x] = true;

        for(int k = 0; k < 8; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && ny >= 0 && nx < w && ny < h){
                if(map[ny][nx] == 1 && !visited[ny][nx]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
