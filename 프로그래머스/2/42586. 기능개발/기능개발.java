import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int n = progresses.length;
        int[] day = new int[n];
        
        // 남은 일 저장
        for (int i = 0; i < n; i++){
            int remain = 100 - progresses[i];
            day[i] = (remain + speeds[i] - 1) / speeds[i];
        }
        
        int releaseDay = day[0];
        int count = 1;
                
        for(int i = 1; i < n; i++){
            if(releaseDay >= day[i]){
                count++;
            } else {
                result.add(count);
                count = 1;
                releaseDay = day[i];
            }
        }
        
        // 마지막 그룹
        result.add(count);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}