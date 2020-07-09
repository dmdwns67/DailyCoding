import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder answer = new StringBuilder();

        int N = sc.nextInt();

        int cnt = 1;
        for(int i=1; i<N+1; i++){
            int data = sc.nextInt();
            while(cnt <= data){
                stack.push(cnt);
                cnt++;
                answer.append('+');
            }
            if(stack.peek() == data){
                stack.pop();
                answer.append('-');
            } else{
                answer = new StringBuilder();
                answer.append("NO");
                break;
            }
        }

        if(answer.toString().equals("NO")){
            System.out.println(answer);
        } else {
            for(int i=0; i<answer.length(); i++){
                System.out.println(answer.charAt(i));
            }
        }

        sc.close();
    }
}