import java.util.*;

public class Main {
    static ArrayList<Integer>[] people;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();

        people = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= n; i++){
            people[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int p = sc.nextInt();
            int c = sc.nextInt();
            people[p].add(c);
            people[c].add(p);
        }

        int result = bfs(x, y);

        System.out.println(result);
    }

    public static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()){
            int curr =  queue.poll();

            if(curr == end) return dist[curr];

            for(int next : people[curr]){
                if(dist[next] == -1){
                    queue.add(next);
                    dist[next] = dist[curr] + 1;
                }
            }
        }
        return -1;
    }
}
