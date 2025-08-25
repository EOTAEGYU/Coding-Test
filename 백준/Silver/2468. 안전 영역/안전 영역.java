import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] area;
    static boolean[][] visited;
    static int maxArea = 0; // 최대 안전 영역
    static int N;
    static int highArea = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        area = new int[N][N];

        // 지역 초기화
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                highArea = Math.max(area[i][j], highArea);
            }
        }

        // 최대 높이까지 비 오는 시물레이션
        for(int h = 0; h <= highArea; h++){
            // 매 높이마다 초기화
            visited = new boolean[N][N];
            int count = 0;

            // 탐색 후 i보다 낮은 지역 물에 잠김(true)
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    // 방문하지 않고 잠기지 않은 곳
                    if (!visited[i][j] && area[i][j] > h){
                        dfs(i, j, h);
                        count++;
                    }
                }
            }
            // 최대 영역 저장
            maxArea = Math.max(count, maxArea);
        }
        System.out.println(maxArea);
    }

    static void dfs(int i, int j, int h){
        visited[i][j] = true;

        for (int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                if (!visited[nx][ny] && area[nx][ny] > h){
                    dfs(nx, ny, h);
                }
            }

        }

    }
}
