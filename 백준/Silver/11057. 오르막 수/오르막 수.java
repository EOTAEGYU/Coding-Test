import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int mod = 10007;
        // dp[자릿수][마지막수]
        int[][] dp = new int[N+1][10];
        
        // 첫자리수 초기화
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i < N+1; i++){
            for(int j = 0; j < 10; j++){
                int sum = 0;
                for(int k = 0; k <= j; k++){
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum % mod;
            }
        }
        
        int result = 0;
        for(int i = 0; i < 10; i++){
            result += dp[N][i];
        }
        System.out.println(result % mod);
    }
}