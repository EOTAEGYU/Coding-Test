import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int count = 0;
            arr = new int[n+1];
            visited = new boolean[n+1];

            for(int j = 1; j <= n; j++){
                arr[j] = sc.nextInt();
            }

            for(int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int s){
        visited[s] = true;
        if(!visited[arr[s]]) {
            dfs(arr[s]);
        }
    }
}
