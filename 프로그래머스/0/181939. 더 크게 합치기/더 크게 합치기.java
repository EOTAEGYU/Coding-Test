class Solution {
    public int solution(int a, int b) {
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        
        int ab = Integer.parseInt(as + bs);
        int ba = Integer.parseInt(bs + as);
        
        int answer = 0;
        
        if(ab > ba){
            answer = ab;
        } else{
            answer = ba;
        }
        
        return answer;
    }
}