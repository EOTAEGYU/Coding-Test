import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참가자 배열 순회하며 <이름, 인원>으로 기록(동명이인 있을 수 있음)
        // 완주자 배열 순회하며 해당 하는 이름의 값 -1
        // 0이 아닌 사람 찾으면 그 사람이 미완주자
        
        // 참가자 인원 파악
        HashMap<String, Integer> parMap = new HashMap<>();
        for(String par : participant){
            parMap.put(par, parMap.getOrDefault(par, 0) + 1);
        }
        
        // 완주자 인원 세기
        for(String com : completion){
            parMap.put(com, parMap.get(com) -1);
        }
        
        for(Map.Entry<String, Integer> entry : parMap.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}