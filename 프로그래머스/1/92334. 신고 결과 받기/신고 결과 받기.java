import java.util.*;

class Solution {
    static Map<String, Set<String>> reportMap; // user별 신고 목록 중복 제거
    static Map<String, Integer> countMap; // user별 신고 횟수
    static List<String> banned; // k이상 신고자
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        reportMap = new HashMap<>();
        
        // 모든 유저 신고 목록 초기화
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        
        for(String r : report){
            String[] list = r.split(" ");
            String reporter = list[0];
            String target = list[1];
            
            reportMap.get(reporter).add(target);
        }
        
        
        // User별 신고 횟수 초기화
        countMap = new HashMap<>();
        for(String id : id_list){
            countMap.put(id, 0);
        }
        
        for (String reporter : reportMap.keySet()) {
            for (String target : reportMap.get(reporter)) {
                countMap.put(target, countMap.get(target) + 1);
            }
        }
        
        // k가 넘어가는 신고자 수 초기화
        banned = new ArrayList<>();
        for(String target : countMap.keySet()){
            if(countMap.get(target) >= k){
                banned.add(target);
                System.out.println(target);
            }
        }
        
        // 
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            int mailCount = 0;
            
            for (String target : reportMap.get(user)){
                if(banned.contains(target))
                    mailCount++;
            }
            answer[i] = mailCount++;
        }
        return answer;
    }
}