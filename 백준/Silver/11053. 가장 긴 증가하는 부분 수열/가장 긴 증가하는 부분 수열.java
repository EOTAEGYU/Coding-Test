import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            // 현재 숫자보다 작은 수중 가장 길이가 긴 숫자 선택
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}