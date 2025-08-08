import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        cost = new int[N];

        long low = 0; // 하루 최대 지출
        long high = 0; // 전체 지출 합

        for(int i = 0; i < N; i++){
            int w = sc.nextInt();
            cost[i] = w;
            if(low < w)
                low = w;
            high += w;
        }

        long ans = high;   // 최소 K를 찾아 저장
        while (low <= high) {
            long mid = (low + high) / 2; // mid를 K로 가정
            if (can(mid)) {              // 이 K로 N일 커버가 M번 이내면 더 줄여본다
                ans = mid;
                high = mid - 1;
            } else {                     // 너무 작아서 인출이 M번 초과 → 늘린다
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean can (long K){
        int withdraw = 0; // 인출 횟수
        long balance = 0; //

        for (int i = 0; i < N; i++){
            if (balance < cost[i]){
                withdraw++;
                balance = K;
            }
            balance -= cost[i];
            if (withdraw > M) return false;
        }
        return withdraw <= M;
    }
}
