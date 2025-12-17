import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i < N+1; i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        if(N == 1) {
            max = arr[1];
        }

        // 이전합 + 현재 vs 현재 값 중 큰 값 갱신
        for(int i = 1; i < N+1; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        
        System.out.println(max);
    }
}
