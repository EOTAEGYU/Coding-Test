import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int[] output;
    public static int N;
    public static int max;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        output = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int depth){
        if(depth == N){
            int sum = 0;
            for(int i = 0; i < N-1; i++){
                sum += Math.abs(output[i] - output[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }
}
