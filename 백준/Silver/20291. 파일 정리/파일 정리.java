import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 확장자 개수 카운트 해시 맵
        HashMap<String, Integer> file = new HashMap<String, Integer>();

        // 확장자 별 카운트
        for(int i = 0; i < N; i++){
            String extension = sc.nextLine().split("\\.")[1];
            file.put(extension, file.getOrDefault(extension, 0) + 1);
        }

        // 정렬
        List<String> extensionList = new ArrayList<>(file.keySet());
        Collections.sort(extensionList);

        for(String ext : extensionList){
            System.out.println(ext + " " + file.get(ext));
        }


    }
}
