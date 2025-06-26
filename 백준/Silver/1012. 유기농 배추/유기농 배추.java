import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    // 상하좌우 방향 벡터
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스

        for(int i = 0; i < T; i++){
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            K = sc.nextInt(); // 배추 개수

            arr = new int[N][M]; // 배추 밭
            visited = new boolean[N][M]; // 방문

            for(int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }

            int count = 0;

            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){
                    if(arr[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N){
                if(arr[ny][nx] == 1 && !visited[ny][nx])
                    dfs(nx, ny);
            }
        }
    }
}
