import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();

            long[] dp = new long[num+1];

            for(int j = 1; j <= num; j++){
                if(j < 4){
                    dp[j] = 1;
                } else if(j < 6){
                    dp[j] = 2;
                } else {
                    dp[j] = dp[j-1] + dp[j-5];
                }
            }

            System.out.println(dp[num]);
        }

    }
}
