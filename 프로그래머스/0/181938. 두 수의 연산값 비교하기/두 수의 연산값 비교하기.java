class Solution {
    public int solution(int a, int b) {
        int ab = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int c = 2 * a * b;
        
        if(ab >= c){
            return ab;
        } else {
            return c;
        }
    }
}