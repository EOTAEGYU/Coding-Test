import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        int aCount = 0;

        // a의 개수 세기
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        // a가 없거나 전부 a일 때
        if (aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        // 처음 aCount 길이 구간의 b 개수
        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }

        int minSwap = bCount;

        // 슬라이딩 윈도우
        for (int i = 1; i < n; i++) {
            // 빠지는 문자
            if (s.charAt((i - 1) % n) == 'b') {
                bCount--;
            }
            // 새로 들어오는 문자
            if (s.charAt((i + aCount - 1) % n) == 'b') {
                bCount++;
            }
            minSwap = Math.min(minSwap, bCount);
        }

        System.out.println(minSwap);
    }
}
