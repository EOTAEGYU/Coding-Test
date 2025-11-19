import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            if(i == n - 1){ // 마지막
                System.out.println("**".repeat(i) + "*");
            } else if(i == 0){ // 첫번째
                System.out.println(" ".repeat(n - i - 1) + "*");
            } else{ // 중간 부분
                System.out.println(" ".repeat(n - i - 1) + "* "
                                  + " ".repeat(2 * (i - 1)) + "*");    
            }
        }
    }
}