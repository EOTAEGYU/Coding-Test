import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];

        dp[0] = 1;
        if(N > 1) dp[2] = 3;

        for(int i = 4; i < N+1; i +=2){
            dp[i] = dp[i-2] * 3;
            for(int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
