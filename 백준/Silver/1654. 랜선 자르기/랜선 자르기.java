import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 줄의 개수
        long N = Integer.parseInt(st.nextToken()); // 만들어야 하는 줄의 개수

        long[] lines = new long[K];
        long maxLine = Integer.MIN_VALUE;
        for(int i = 0; i < K; i++){
            long line = Integer.parseInt(br.readLine());
            lines[i] = line;
            maxLine = Math.max(line, maxLine);
        }

        long min = 0;
        long max = maxLine;
        max++;

        while (min < max){
            long mid = (min + max) / 2;
            long count = 0;

            for(int i = 0; i < K; i++){
                count += lines[i]/mid;
            }

            if (count < N){
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}
