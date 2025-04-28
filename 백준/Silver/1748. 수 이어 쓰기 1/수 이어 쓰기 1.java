import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int digit = 1; // 자릿수
        int start = 1; // 현재 자릿수의 시작 숫자
        int length = 0;

        while (start * 10 <= n) {
            length += (start * 10 - start) * digit;
            start *= 10;
            digit++;
        }

        // 마지막 남은 부분
        length += (n - start + 1) * digit;

        System.out.println(length);
    }
}
