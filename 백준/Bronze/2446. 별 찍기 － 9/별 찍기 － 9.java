import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 1; i <= 2 * n - 1; i++){
            if(i <= n){
                System.out.println(" ".repeat(i - 1) + "*" + "*".repeat((n - i) * 2));
            } else {
                int j = i - n;  // 1, 2, 3, ...
                System.out.println(" ".repeat(n - j - 1)
                        + "*".repeat(2 * j + 1));
            }
        }
    }
}