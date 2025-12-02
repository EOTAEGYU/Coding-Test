import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        // 포도주
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        
        for(int i = 1; i < N+1; i++){
            arr[i] = sc.nextInt();
        }
        
        dp[1] = arr[1];
        if(N >= 2) dp[2] = arr[1] + arr[2];
        if (N >= 3) dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));
        
        for(int i = 4; i < N+1; i++){
            int case1 = dp[i-1];
            int case2 = dp[i-3] + arr[i-1] + arr[i];
            int case3 = dp[i-2] + arr[i];
            
            // 세 값 중 최댓값 구하기
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }
        
        System.out.println(dp[N]);
    }
}