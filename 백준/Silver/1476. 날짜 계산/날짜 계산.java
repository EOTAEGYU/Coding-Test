import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int year = 1;
        
        while (true) {
            int earth = (year - 1) % 15 + 1;
            int sun = (year - 1) % 28 + 1;
            int moon = (year - 1) % 19 + 1;

            if (earth == E && sun == S && moon == M) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }
}
