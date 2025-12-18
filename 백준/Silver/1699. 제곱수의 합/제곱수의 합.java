import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];

        for(int i = 0; i < N+1; i++){
            dp[i] = i;
            for(int j = 0; j * j <= i; j++){
                if(dp[i] > dp[i-j*j] + 1){
                    dp[i] = dp[i-j*j] + 1;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
