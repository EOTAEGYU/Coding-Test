import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
        }

        Arrays.sort(points, (p1, p2) -> {
            if(p1[1] == p2[1]){
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(points[i][j] + " ");
            }
            System.out.println();
        }
    }
}
