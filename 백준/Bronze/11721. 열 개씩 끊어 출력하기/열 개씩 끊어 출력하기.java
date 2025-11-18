import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int n = text.length()/10 + 1;
        
        for(int i = 0; i < n; i++){
            if(i == n - 1){
                System.out.println(text.substring((10*i)));
            } else {
                System.out.println(text.substring((10 * i), 10 * (i + 1)));
            }
        }
    }
}