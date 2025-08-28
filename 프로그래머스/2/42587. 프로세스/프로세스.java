import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 큐에 우선순위 인덱스 삽입
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{priorities[i], i});
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            boolean hasHigher = false;
            for(int[] q : queue){
                if(q[0] > current[0]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                queue.offer(current);
            }else{
                count++;
                if(current[1] == location){
                    return count;
                }
            }
        }
        
        
        return -1;
    }
}