import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);

        List<Integer> BList = Arrays.asList(B);
        BList.sort(Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * BList.get(i);
        }

        System.out.println(result);
    }
}
