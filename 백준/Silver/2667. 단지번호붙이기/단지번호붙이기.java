import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int home;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 배열 초기화
        for(int i = 0; i < N; i++){
            char[] list = sc.next().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = list[j] - '0';
            }
        }

        int count = 0; // 단지 개수
        ArrayList<Integer> homes = new ArrayList<>(); // 단지 내 집 개수

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && map[y][x] == 1) { // 방문하지 않은 집 탐색
                    count++;
                    home = 1;
                    dfs(y, x);
                    homes.add(home);
                }
            }
        }
        Collections.sort(homes); // 오름차순 정렬

        // 정답 출력
        System.out.println(count);
        for(int n : homes){
            System.out.println(n);
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    dfs(ny, nx);
                    home++;
                }
            }
        }
    }
}
