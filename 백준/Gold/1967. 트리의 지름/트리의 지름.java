import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int id;      // 연결된 노드 번호
    int weight;  // 간선의 가중치 (거리)

    Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}
public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDist;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수

        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 트리 배열 초기화 (1번부터 n번까지)
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리에 간선 정보 저장
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        maxDist = 0;
        visited = new boolean[n+1];
        dfs(1, 0);

        visited = new boolean[n+1];
        maxDist = 0;
        dfs(maxNode, 0);

        System.out.println(maxDist);
        
    }

    static void dfs(int current, int dist){
        visited[current] = true;

        if(maxDist < dist){
            maxDist = dist;
            maxNode = current;
        }

        for(Node node : tree[current]){
            if(!visited[node.id]){
                dfs(node.id, dist + node.weight);
            }
        }
    }
}
