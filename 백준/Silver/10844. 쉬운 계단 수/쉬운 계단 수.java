// 길이가 n인 계단 수가 총 몇개 있는지
// [자릿수][마지막수]

import java.util.*;

public class Main{
    
    final static long mod = 1000000000;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long[][] dp = new long[n+1][10];
        
        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의수 1개 밖에 없음
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                // 0이면 이전 자릿수의 마지막이 1인 수
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % mod;
                }
                // 9면 이전 자릿수의 마지막이 8인 수
                else if(j == 9){
                    dp[i][9] = dp[i-1][8] % mod;
                }
                // 나머지 수들은 이전 자릿수의 +- 1 모두 들어올 수 있음
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        
        long result = 0;
        
        for(int i = 0; i < 10; i++){
            result += dp[n][i];
        }
        
        System.out.println(result % mod);
    }
}