import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 입력값 초기화
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];

            StringTokenizer st;

            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            if (N == 1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }

            // 초기값 초기화
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            // 전 or 전전 중 더 큰값 +
            for(int j = 2; j < N; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }
}
