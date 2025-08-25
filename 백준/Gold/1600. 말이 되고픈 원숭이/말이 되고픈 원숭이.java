import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    // 원숭이 이동 (상하좌우)
    static int[] dx4 = {1, -1, 0, 0};
    static int[] dy4 = {0, 0, 1, -1};

    // 말 이동 (체스 나이트)
    static int[] dx8 = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy8 = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Node {
        int x, y, k, dist;
        Node(int x, int y, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H][W][K+1];

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 도착지에 도달하면 반환
            if (cur.x == W-1 && cur.y == H-1) {
                return cur.dist;
            }

            // 1. 원숭이 일반 이동
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx4[d];
                int ny = cur.y + dy4[d];

                if (nx>=0 && nx<W && ny>=0 && ny<H && !visited[ny][nx][cur.k] && map[ny][nx]==0) {
                    visited[ny][nx][cur.k] = true;
                    q.add(new Node(nx, ny, cur.k, cur.dist+1));
                }
            }

            // 2. 말 이동 (k < K 일 때만 가능)
            if (cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + dx8[d];
                    int ny = cur.y + dy8[d];

                    if (nx>=0 && nx<W && ny>=0 && ny<H && !visited[ny][nx][cur.k+1] && map[ny][nx]==0) {
                        visited[ny][nx][cur.k+1] = true;
                        q.add(new Node(nx, ny, cur.k+1, cur.dist+1));
                    }
                }
            }
        }

        // 도착 못 하면 -1
        return -1;
    }
}
