import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 코스 수
        long K = sc.nextLong();  // 이동 거리
        int[] course = new int[N];

        long total = 0;
        for (int i = 0; i < N; i++) {
            course[i] = sc.nextInt();
            total += course[i];
        }

        long distance = 0;
        if (K < total) {
            // 가는 길
            for (int i = 0; i < N; i++) {
                distance += course[i];
                if (K < distance) {
                    System.out.println(i + 1);
                    return;
                }
            }
        } else {
            // 돌아오는 길
            for (int i = N - 1; i >= 0; i--) {
                distance += course[i];
                if (K < total + distance) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
