import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] box;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        box = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 익지않은 토마토 개수, 토마토 큐에 넣기
        int unTomato = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (box[i][j] == 0){
                    unTomato++;
                } else if(box[i][j] == 1){
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        int maxDay = 0;

        // 2. BFS 탐색으로 토마토 익히기
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int day = current[2];
            maxDay = day;

            for(int k = 0; k < 4; k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m){
                    if(box[ny][nx] == 0){
                        int nextDay = day + 1;
                        queue.add(new int[]{ny, nx, nextDay});
                        box[ny][nx] = 1;
                        unTomato--;
                    }
                }
            }
        }

        if(unTomato > 0){
            System.out.println(-1);
        } else {
            System.out.println(maxDay);
        }

    }
}
