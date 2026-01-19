import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int num;
        int weight;

        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] tree;
    static int max = 0;
    static int maxNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        tree = new ArrayList[v+1];

        for(int i = 1; i <= v; i++){
            tree[i] = new ArrayList<>();
        }

        // 입력 받기
        for(int i = 1; i <= v; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int cur;
            while ((cur = Integer.parseInt(st.nextToken())) != -1){
                int weight = Integer.parseInt(st.nextToken());
                Node node = new Node(cur, weight);
                tree[n].add(node);
            }
        }

        // 1번 노드에서 가장 먼 노드 찾고, 그 노드에서 가장 먼 노드 길이 구하기
        visited = new boolean[v+1];
        dfs(1, 0);

        visited = new boolean[v+1];
        max = 0;
        dfs(maxNode, 0);

        System.out.println(max);

    }

    static public void dfs(int n, int sum){
        visited[n] = true;
        if(max < sum){
            maxNode = n;
            max = sum;
        }

        for(Node next : tree[n]){
            if(!visited[next.num]){
                dfs(next.num, sum + next.weight);
            }
        }
    }
}
