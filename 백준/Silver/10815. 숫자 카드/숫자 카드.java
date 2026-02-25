import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 잇는 숫자 카드 개수
        int[] cardList = new int[N];

        // 상근이 카드 입력 후 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cardList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cardList);
        /*for(int i = 0; i < N; i++){
            System.out.print(cardList[i] + " ");
        }*/

        int M = Integer.parseInt(br.readLine()); // 정수 M 개
        int[] num = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[M]; // 결과 저장
        for(int i = 0; i < M; i++){
            // 최소/최댓값 위치
            int min = 0;
            int max = N-1;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (num[i] == cardList[mid]) {
                    result[i] = 1;
                    break;
                } else if (num[i] > cardList[mid]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }

        for(int i = 0; i < M; i++){
            System.out.print(result[i] + " ");
        }

    }
}
