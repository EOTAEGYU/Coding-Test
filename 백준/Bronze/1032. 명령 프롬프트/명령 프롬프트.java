import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = new String[n];

        for(int i = 0; i < n; i++){
            str[i] = sc.next();
        }
        
        StringBuilder sb = new StringBuilder(str[0]);

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < str[0].length(); j++){
                if(str[i].charAt(j) != str[i+1].charAt(j)){
                    sb.setCharAt(j, '?');
                }
            }
        }
        
        System.out.println(sb);

    }
}
