// N마리의 포켓몬 중 N/2 마리 선택 -> 포켓몬 종류 개수의 최댓값 출력
// HashMap을 사용하여 <포켓몬, 마리수> 저장
// 포켓몬 종류가 N/2 보다 같거나, 작으면 포켓몬 종류 수 출력
// 포켓몬 종류가 N/2 보다 크면 N/2 출력 


import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> poketmon = new HashMap<>();
        
        // 포켓몬 종류 저장
        for (int i : nums){
            poketmon.put(i, poketmon.getOrDefault(i, 0) + 1);
        }
        
        Set<Integer> poketNum = poketmon.keySet();
        
        int numSize = nums.length; // 포켓몬 마리수
        int size = poketNum.size(); // 포켓몬 종류수
        
        if(size <= (numSize/2)){
            return size;
        } else {
            return numSize/2;
        }        
    }
}