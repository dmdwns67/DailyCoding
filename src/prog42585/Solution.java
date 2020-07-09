import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        String arrangement = "()(((()())(())()))(())";

        int answer = solution(arrangement);

        System.out.println(answer);
    }

    public static int solution(String arrangement) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();

        String arr = arrangement.replace("()", "0");
        
        for(int i=0; i<arr.length(); i++){
            if(arr.charAt(i) == '0') {
                // laser case
                if(!stack.isEmpty()) answer += stack.size();
            } else if(arr.charAt(i) == '('){
                // start of stick  
                stack.push(i);
            } else if(arr.charAt(i) == ')') {
                // end of stick
                stack.pop();
                answer++;
            }
        }
            
        return answer;
    }
}