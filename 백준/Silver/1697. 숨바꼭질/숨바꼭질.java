import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈(출발)
        int M = sc.nextInt(); // 동생(도착)

        boolean[] visited = new boolean[1000001];
        int[] dx = {1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()){
            int[] p = q.poll();

            int cur = p[0];
            int second = p[1];

            // 도착시 시간 출력
            if(cur == M){
                System.out.print(second);
                break;
            }

            // 3가지 경로 추가
            for(int i = 0; i < 3; i++){
                int nx = 0;
                if(i == 2) {
                    nx = cur * 2;
                } else {
                    nx = cur + dx[i];
                }
                if(nx >= 0 && nx <= 1000000 && !visited[nx]){
                    visited[nx] = true;
                    q.add(new int[]{nx, second+1});
                }
            }
        }
    }
}
