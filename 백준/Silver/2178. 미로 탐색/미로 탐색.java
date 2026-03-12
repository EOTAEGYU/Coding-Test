import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // Y
        M = sc.nextInt(); // X

        // 미로 저장
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next(); // 한 줄을 문자열로 읽음
            for (int j = 1; j <= M; j++) {
                // charAt(j-1)을 통해 문자를 하나씩 가져온 뒤 '0'을 빼서 숫자로 변환
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        bfs();

        System.out.println(map[N][M]);
    }

    public static void bfs(){
        visited[1][1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1}); // {y, x}

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            // 인접한 곳 중 길이 있으면 추가
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx > 0 && ny > 0 && nx < M+1 && ny < N+1){
                    if(!visited[ny][nx] && map[ny][nx] > 0){
                        visited[ny][nx] = true;
                        map[ny][nx] = map[cy][cx] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

    }
}
