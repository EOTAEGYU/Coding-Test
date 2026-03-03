import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static boolean[] errorButtons;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 이동하려는 채널
        int M = sc.nextInt(); // 고장난 버튼 개수
        
        errorButtons = new boolean[10];

        for (int i = 0; i < M; i++) {
            int b = sc.nextInt();
            errorButtons[b] = true;
        }

        int minPress = Math.abs(N - 100);

        for(int i = 0; i <= 1000000; i++){
            int len = check(i); // 누를 수 있는 버튼 탐색

            if(len > 0){
                int press = len + Math.abs(N - i);
                minPress = Math.min(minPress, press);
            }
        }

        System.out.println(minPress);
    }

    private static int check(int i) {
        if(i == 0){
            return errorButtons[0] ? 0 : 1;
        }

        int count = 0;
        while (i > 0){
            if(errorButtons[i % 10]) return 0; // 고장난 버튼이 하나라도 있으면 0
            count++;
            i /= 10;
        }
        return count;
    }
}
