import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong(); // 총 게임 수
        long Y = sc.nextLong(); // 이긴 게임 수

        long Z = (Y * 100) / X;

        if (Z >= 99) {         // 승률이 더 이상 변하지 않음
            System.out.println(-1);
            return;
        }

        long start = 0;
        long end = 2000000000;
        long ans = -1;

        while (start <= end){
            long mid = (start + end) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);
            if (newZ > Z){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
