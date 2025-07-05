import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // x축: 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // y축: 상하좌우

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 지도 크기
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complexSizes = new ArrayList<>(); // 각 단지 내 집의 수
        int totalComplexes = 0; // 단지 수

        for (int i = 0; i < N; i++) { // y축
            for (int j = 0; j < N; j++) { // x축
                if (map[i][j] == 1 && !visited[i][j]) {
                    // 새로운 단지 발견
                    int size = dfs(j, i);
                    complexSizes.add(size);
                    totalComplexes++;
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(complexSizes);

        // 출력
        System.out.println(totalComplexes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    // DFS
    static int dfs(int x, int y) {
        visited[y][x] = true;
        int count = 1; // 현재 집 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위 확인 및 조건 검사
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    count += dfs(nx, ny); // 연결된 집 탐색
                }
            }
        }

        return count;
    }
}
