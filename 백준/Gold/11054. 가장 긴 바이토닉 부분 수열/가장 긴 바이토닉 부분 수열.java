import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = sc.nextInt();
        }
        int[] inDP = new int[n+1];
        int[] deDP = new int[n+1];

        // 증가하는 수
        for(int i = 1; i < n+1; i++){
            inDP[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){
                    inDP[i] = Math.max(inDP[i], inDP[j] + 1);
                }
            }
        }

        // 역으로 증가하는 수
        for(int i = n; i > 0; i--){
            deDP[i] = 1;
            for(int j = n; j > i; j--){
                if(arr[i] > arr[j]){
                    deDP[i] = Math.max(deDP[i], deDP[j] + 1);
                }
            }
        }

        int max = 0;

        for(int i = 1; i < n+1; i++){
            max = Math.max(max, inDP[i] + deDP[i] - 1);
        }

        System.out.println(max);
    }
}