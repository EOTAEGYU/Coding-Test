import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int P;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int A = sc.nextInt();
        P = sc.nextInt();
        list.add(A);

        while (true){
            int current = list.get(list.size()-1); // 마지막 수
            int nextValue = getNextValue(current); // 다음 수

            if(list.contains(nextValue)){
                System.out.println(list.indexOf(nextValue));
                break;
            }
            list.add(nextValue);
        }
    }

    public static int getNextValue(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10; // 마지막 자리수

            // 거듭제곱 계산
            int result = 1;
            for (int j = 0; j < P; j++) {
                result *= digit;
            }

            sum += result;
            n /= 10; // 다음 자리수로 이동
        }
        return sum;
    }


}
