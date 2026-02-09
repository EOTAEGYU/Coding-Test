import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            long card = sc.nextLong();
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        long result = 0;
        int maxCount = 0;

        for(long key : map.keySet()){
            int count = map.get(key);

            if(count > maxCount){
                maxCount = count;
                result = key;
            }
            else if(count == maxCount){
                if (key < result){
                    result = key;
                }
            }
        }

        System.out.println(result);
    }
}
