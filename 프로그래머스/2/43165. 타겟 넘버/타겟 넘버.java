class Solution {
    static int length;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        length = numbers.length;
                
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int sum, int depth, int target){
        if(depth == length){
            if(sum == target){
                answer++;
                return;
            }
            return;
        }
        
        dfs(numbers, sum + numbers[depth], depth+1, target);
        dfs(numbers, sum - numbers[depth], depth+1, target);
    }
}