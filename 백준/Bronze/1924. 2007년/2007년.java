// 일수로 전환하고 빼기로 계산
// 각 배열에 달의 일 수 누적합 저장
// 1   2   3   4   5   6   7   8   9   10  11  12
// 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sum = new int[13];
        
        // 누적합
        for(int i = 1; i < 13; i++){
            sum[i] = sum[i - 1] + monthDay[i]; 
        }
        
        int month = sc.nextInt();
        int day = sc.nextInt();
        
        int result = (sum[month - 1] + day)%7;
        
        switch (result){
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            case 0:
                System.out.println("SUN");
                break;
        }
        
    }
}