import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int good = 0;
        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int target = arr[i];
            int s = 0;
            int e = N -1;
            while(s < e){
                if(s == i){
                    s++;
                    continue;
                }
                if(e == i){
                    e--;
                    continue;
                }
                int sum = arr[e] + arr[s];
                if(target == sum){
                    good++;
                    break;
                } else if (target > sum){
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(good);
    }
}
