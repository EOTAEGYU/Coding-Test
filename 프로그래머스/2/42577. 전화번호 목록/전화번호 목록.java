// 전화번호부에 있는 번호중 다른 번호의 접두사인 경우 false 출력
// 가장 길이가 짧은 순서로 정렬, 큰 수가 접두사가 될 수 없기 때문에 길이가 작은 수 부터 순회
// 
//

import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public boolean solution(String[] phone_book) {
        //1. 전화번호부 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String phone : phone_book){
            map.put(phone, 1);
        }
        
        //2. 접두사 조회
        for(String phone: phone_book){
            for(int i = 1; i < phone.length(); i++){
                String num = phone.substring(0, i);
                if(map.containsKey(num)){
                    return false;
                }
            }
        }
        return true;
        
        
    }
}