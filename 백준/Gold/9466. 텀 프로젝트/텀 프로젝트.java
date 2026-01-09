import java.util.*;

public class Main {
    static int[] choices;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){

            int n = sc.nextInt();
            choices = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            for(int j = 1; j <= n; j++){
                choices[j] = sc.nextInt();
            }

            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    dfs(j);
                }
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int now){
        visited[now] = true;
        int next = choices[now];

        if(!visited[next]){
            dfs(next);
        }else{
            // 재방문해서 사이클 찾기
            if(!finished[next]) {
                for (int temp = next; temp != now; temp = choices[temp]) {
                    count++;
                }
                count++;
            }
        }

        finished[now] = true;
    }
}