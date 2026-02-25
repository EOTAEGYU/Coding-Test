import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // 가지고 있는 카드 HashMap 개수 만큼 저장
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 가지고 있는 카드 개수 출력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
