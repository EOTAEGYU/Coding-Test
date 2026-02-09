import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push" :{
                    int n = Integer.parseInt(st.nextToken());
                    push(n);
                    break;
                }
                case "top" : {
                    top();
                    break;
                }
                case "size" : {
                    size();
                    break;
                }
                case "empty" : {
                    empty();
                    break;
                }
                case "pop" : {
                    pop();
                    break;
                }
            }
        }



    }
    public static void push(int n){
        stack.push(n);
    }
    public static void pop(){
        if(!stack.isEmpty()){
            System.out.println(stack.pop());
        }else {
            System.out.println(-1);
        }
    }
    public static void size(){
        System.out.println(stack.size());
    }
    public static void empty(){
        if(stack.isEmpty()){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static void top(){
        if(!stack.isEmpty()){
            System.out.println(stack.peek());
        } else {
            System.out.println(-1);
        }

    }
}
