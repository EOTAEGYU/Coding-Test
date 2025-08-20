// 피자 먹는 사람 n 한 조각 이상 먹으려면

class Solution {
    public int solution(int slice, int n) {
        // 피자 조각이 사람 수랑 같거나 클 때까지 반복
        int count = 1;
        
        while (slice * count < n) {
            count++;
        }
        return count;
    }
}