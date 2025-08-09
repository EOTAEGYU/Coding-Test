import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int[] dp = new int[K+1];

        for(int i = 1; i <= N; i++){
            for(int w = K; w >= weights[i]; w--){
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
