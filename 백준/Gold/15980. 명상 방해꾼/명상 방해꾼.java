import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] bird;
    static int[] totalSum;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 새 저장
        bird = new int[n+1][m];
        totalSum = new int[m];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            // L이면 -1
            int direction = str1.equals("L") ? -1 : 1;

            // 누적합
            for(int j=0; j<m; j++){
                bird[i][j] = (str2.charAt(j) == '1') ? direction : 0;
                totalSum[j] += bird[i][j];
            }
        }

        int resultBird = 0;
        int min = Integer.MAX_VALUE;

        // 1번부터 N번까지 잡았을 때 방해 저장
        for(int i=1; i<=n; i++){
            int now = 0;
            int max = 0;
            for(int j=0; j<m; j++){
                int temp = totalSum[j] - bird[i][j];
                now += temp; // 중심값
                max = Math.max(max, Math.abs(now)); // 최대 중심값
            }
            if(max < min){
                min = max;
                resultBird = i;
            }
        }
        System.out.println(resultBird);
        System.out.println(min);
    }
}