public class Solution {
    public static void main(String[] args){
        int n = 10;

        String answer = solution(n);

        System.out.println(answer);
    }

    public static String solution(int n){
        String answer = "";
        String[] order = {"1", "2", "4"};
        
        int num = n;
        while(num > 0){
            int remainder = num % 3;
            num =  num/3;
            
            if(remainder == 0){
                num--;
                remainder = 3;
            }
            
            answer = order[remainder-1] + answer;
        }
        
        return answer;
    }
}