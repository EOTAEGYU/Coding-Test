import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int T;
    static int x1, y1, x2, y2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++){
            L = Integer.parseInt(br.readLine());

            arr = new int[L][L];
            visited = new boolean[L][L];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            bfs();

            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[x1][y1] = true;
        queue.add(new int[]{x1, y1});
        
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            // 8가지 방향 탐색
            for (int i = 0; i < 8; i++){
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                // 제한 된 구역에서만 탐색
                if (ox >= 0 && oy >=0 && ox < L && oy < L){
                    if(!visited[ox][oy]){
                        queue.add(new int[]{ox, oy});
                        visited[ox][oy] = true;
                        arr[ox][oy] = arr[nx][ny] + 1; // 탐색 횟수 추가
                    }
                }
            }
        }
    }
}
