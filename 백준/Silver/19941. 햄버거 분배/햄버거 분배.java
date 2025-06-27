import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[] info;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 식탁 길이
        int K = Integer.parseInt(st.nextToken()); // 햄버거 선택 거리

        info = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (info[i] == 'P') {
                selectHamburger(i, K, N);
            }
        }

        System.out.println(result);
    }

    // 사람 p 위치에서 거리 K 이내 햄버거 탐색
    static void selectHamburger(int p, int k, int N) {
        int start = Math.max(0, p - k);
        int end = Math.min(N - 1, p + k);

        for (int i = start; i <= end; i++) {
            if (info[i] == 'H') {
                info[i] = 'E'; // 먹은 햄버거는 사용 처리
                result++;
                break;
            }
        }
    }
}
