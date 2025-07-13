import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int paint = 0;
    static int maxSize = 0;
    static int[] dx = {0, 0, -1, 1}; // x축: 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // y축: 상하좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        paper = new int[n][m];
        visited = new boolean[n][m];

        // 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (paper[i][j] == 1 && !visited[i][j]){
                    paint++;
                    int size = dfs(i , j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(paint);
        System.out.println(maxSize);
    }

    static int dfs (int i, int j){
        visited[i][j] = true;
        int count = 1;

        for (int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(paper[nx][ny] == 1 && !visited[nx][ny]){
                    count += dfs(nx, ny);
                }
            }
        }
        return count;
    }

}
