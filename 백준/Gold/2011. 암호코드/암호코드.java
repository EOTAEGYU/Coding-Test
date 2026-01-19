import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int length = s.length();
        char[] code = s.toCharArray();

        // dp[i]는 i번째 글자까지의 해석 가짓수
        int[] dp = new int[length + 1];
        dp[0] = 1; // 아무것도 없는 상태도 하나의 경우로 간주 (두 자리 수 계산용)

        for (int i = 1; i <= length; i++) {
            int cur = code[i - 1] - '0'; // 현재 글자

            // 1. 한 자리 수로 해석 (1~9)
            if (cur >= 1 && cur <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }

            if (i == 1) continue; // 첫 번째 글자는 이전 글자가 없으므로 생략

            int pre = code[i - 2] - '0'; // 이전 글자
            int value = pre * 10 + cur;  // 두 글자를 합친 값

            // 2. 두 자리 수로 해석 (10~26)
            if (value >= 10 && value <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }

        System.out.println(dp[length]);
    }
}
