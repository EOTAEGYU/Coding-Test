// 각 크기마다 채울 수 있는 경우의 수 구하고 dp로 해당 수 까지 합하기
// 경우의 수 구하는 법
// 2x2는 2가지 dp[2] = 2
// 2x3은 dp[2] + dp[1] = 3
// 2x4는 dp[3] + dp[2] = 5?

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n>1) dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] % 10007);
        }
        
        System.out.println(dp[n] % 10007);
    }
}