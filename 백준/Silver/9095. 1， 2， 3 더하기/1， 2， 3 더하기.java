// 정수 1,2,3으로만 합
// dp[1] = 1
// dp[2] = 2 (1+1, 2) , dp[3] = 4 (1+1+1, 1+2, 2+1, 3) dp[2] + dp[1] +
// dp[4] = dp[3] + dp[2] + dp[1]

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[] num = new int[T];
        int max = 0;
        
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            num[i] = n;
            max = Math.max(max, n);
        }
        
        int[] dp = new int[max+1];
        dp[1] = 1;
        if(max > 1) dp[2] = 2;
        if(max > 2) dp[3] = 4;
        
        for(int i = 4; i <= max; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        
        for(int i = 0; i < T; i++){
            System.out.println(dp[num[i]]);
        }
        
    }
}