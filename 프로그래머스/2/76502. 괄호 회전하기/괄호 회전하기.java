import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        for(int i = 0; i < s.length(); i++){
            if(isTrue(str)) answer++;
            String first = String.valueOf(str.charAt(0));
            str = str.substring(1) + first;
        }        
        return answer;
    }
    
    static public boolean isTrue(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){ // 여는 괄호면 push
            char cur = str.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            } else{ // 닫는 괄호면 pop 하지만 스택의 최상위 값과 맞아야함
                if(stack.isEmpty()){
                    return false;
                } else{
                    char c = stack.peek();
                    if(c == '(' && cur == ')'){
                        stack.pop();
                    }else if(c == '{' && cur == '}'){
                        stack.pop();
                    }else if(c == '[' && cur == ']'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}