import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Shortcut{
        int start, end, length;
        Shortcut(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 지름길 저장
        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (e <= D && e > s && l < (e - s)){
                shortcuts.add(new Shortcut(s, e, l));
            }
        }

        int[] distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // DP
        for (int i = 0; i <= D; i++){
            // 등록 되어 있는 길보다 짧은 길 등록
            if(i < D){
                distance[i + 1] = Math.min(distance[i + 1], distance[i] + 1);
            }

            // 지름길 있으면 등록
            for(Shortcut sh : shortcuts){
                if(sh.start == i){
                    distance[sh.end] = Math.min(distance[sh.end], distance[sh.start] + sh.length);
                }
            }
        }

        System.out.println(distance[D]);

    }
}
