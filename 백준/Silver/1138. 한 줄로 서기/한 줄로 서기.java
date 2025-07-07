import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        // 출력
        int[] result = new int[N];

        for(int i = 0; i < N; i++){
            int tall = i + 1; // 키
            int count = arr[i]; // 왼쪽 키 큰 사람의 수

            int point = 0; // 탐색 위치
            int blank = 0; // 빈 칸

            while(true){
                if(result[point] == 0){
                    if(blank == count){
                        result[point] = tall;
                        break;
                    }
                    blank++;
                }
                point++;
            }
        }
        for (int i : result){
            System.out.print(i + " ");
        }
    }
}
