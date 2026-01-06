import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean isBipartite;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i ++){
            int v = sc.nextInt();
            int e = sc.nextInt();
            list = new ArrayList[v+1];
            check = new int[v+1];
            isBipartite = true;

            for(int k = 1; k < v+1; k++){
                list[k] = new ArrayList<>();
            }

            for(int j = 0; j < e; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                list[a].add(b);
                list[b].add(a);
            }

            for(int j = 1; j <= v; j++){
                if(check[j] == 0){
                    dfs(j, 1);
                }
            }
            System.out.println(isBipartite? "YES" : "NO");
        }
    }

    static public void dfs(int s, int color){
        check[s] = color;
        for(int next : list[s]){
            if(check[next] == 0){
                dfs(next, 3 - color);
            } else if(check[next] == check[s]){
                isBipartite = false;
                return;
            }
        }
    }
}
