import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        String[] graph = new String[T];

        for (int i = 0; i < T; i++){
            graph[i] = sc.nextLine();
        }

        int max = 0;

        for (int i = 0; i < T; i++){
            // 중복 친구
            Set<Integer> twoFriends = new HashSet<>();

            for (int j = 0; j < T; j++){
                if(i==j) continue;

                // 친구 일 때
                if(graph[i].charAt(j) == 'Y'){
                    twoFriends.add(j);

                    // 친구의 친구
                    for(int k = 0; k < T; k++){
                        if(k != i && graph[j].charAt(k) == 'Y'){
                            twoFriends.add(k);
                        }
                    }
                }
            }
            max = Math.max(max, twoFriends.size());
        }

        System.out.println(max);
    }
}
