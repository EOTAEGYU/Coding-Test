import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String line = sc.nextLine();
            for (int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);

    }

    // bfs
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 범위 안이고 방문하지 않았을 때
                if(nextX >= 0 && nextY >=0 && nextX < N && nextY < M){
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        queue.add(new int[]{nextX, nextY});
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                        visited[nextX][nextY] = true;
                    }
                }

            }
        }
    }
}

