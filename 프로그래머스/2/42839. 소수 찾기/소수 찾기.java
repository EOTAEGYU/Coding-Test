// 숫자 조합으로 소수 구하기
// 문자 문자열로 배치
// 모든 문자 사용 X
// 소수 구하는 법
// 
// 문자열 리스트[] 문자열 길이만큼 반복 1~n 칸까지
// 1, 2, 3, 4
// 문자열 [0] -> 
// 3칸일때 [0]-> 123 124, 132 134, 142 143
//        [1]-> 213 214, 231 234, 241 243
//        [2]-> 312 314, 321 324, 341 342
//        [3]-> 412 413, 421 423, 431 432
import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        
        dfs(numbers, "", 0);
        
        int answer = 0;

        for (int num : set){
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    static public void dfs(String numbers, String s, int depth){
        
        // 끝까지 탐색했는지 체크
        if(depth > numbers.length())
            return;
        
        // 탐색 후 저장
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;    
            }
        }
        
    }
    
    static public boolean isPrime(int number){
        if(number <= 1){
            return false;
        }
        for(int i = 2; i < number; i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
}