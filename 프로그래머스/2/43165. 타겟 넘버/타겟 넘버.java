class Solution {
    static int count = 0;
    static int tar;
    
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        tar = target;
        dfs(numbers, 0, n, 0);
        return count;
    }
    
    static public void dfs(int[] numbers, int sum, int n, int len){
        if(len == n) {
            if(sum == tar){
                count++;
            }
            return;
        }
        dfs(numbers, sum + numbers[len], n, len + 1);
        dfs(numbers, sum - numbers[len], n, len + 1);
    }
}