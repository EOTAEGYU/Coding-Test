import java.util.*;

public class Main {
    static ArrayList<Integer> list[];
    static boolean visited[];
    static boolean visited2[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        DFS(V);
        visited2 = new boolean[N + 1];
        System.out.println();
        BFS(V);

    }

    static void DFS (int n){
        System.out.print(n + " ");
        visited[n] = true;
        for (int i : list[n]){
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS (int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited2[n] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i : list[v]){
                if(!visited2[i]){
                    visited2[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
