import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        int maxHigh = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        for(int i = 0; i < N; i++){
            int high = Integer.parseInt(st.nextToken());
            trees[i] = high;
            maxHigh = Math.max(high, maxHigh);
        }

        long min = 0;
        long max = maxHigh;
        max++;

        while (min < max){
            long mid = (min + max) / 2;

            long tree = 0; // 가져갈 수 있는 나무의 길이
            for(int i = 0; i < N; i++){
                if(trees[i] > mid){
                    tree += trees[i] - mid;
                }
            }

            if (tree >= M){
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}
