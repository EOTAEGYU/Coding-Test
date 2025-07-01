import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int N;
    static int M;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        // 입력값 초기화
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        // 8x8 영역 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                check(i, j);
            }
        }
        System.out.println(min);
    }

    static void check(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int repaintW = 0; // 왼쪽 위가 W일 때 바꾸는 수
        int repaintB = 0; // 왼쪽 위가 B일 때 바꾸는 수

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if ((i + j) % 2 == 0) {
                    if (arr[i][j] != 'W') repaintW++;
                    if (arr[i][j] != 'B') repaintB++;
                } else {
                    if (arr[i][j] != 'B') repaintW++;
                    if (arr[i][j] != 'W') repaintB++;
                }
            }
        }

        // 최솟값 비교
        min = Math.min(min, Math.min(repaintW, repaintB));
    }
}

