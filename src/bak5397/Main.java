import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++){
            String input = sc.next();
            List<Character> left = new ArrayList<Character>();
            Stack<Character> right = new Stack<Character>();

            for(int j=0; j<input.length(); j++){
                if(input.charAt(j) == '<') {
                    // move an element from left ArrayList to right Stack
                    if(!left.isEmpty()){
                        int idx = left.size()-1;
                        right.push(left.get(idx));
                        left.remove(idx);
                    }
                } else if(input.charAt(j) == '>'){
                    // move an element from right Stack to left ArrayList
                    if(!right.isEmpty()){
                        left.add(right.pop());
                    }
                } else if(input.charAt(j) == '-') {
                    // remove an element in left ArrayList
                    if(!left.isEmpty()){
                        left.remove(left.size()-1);
                    }
                } else {
                    // add an element to left ArrayList
                    left.add(input.charAt(j));
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int k=0; k<left.size(); k++){
                sb.append(left.get(k));
            }
            while(!right.isEmpty()){
                sb.append(right.pop());
            }

            System.out.println(sb);
        }

        sc.close();
    }
}