import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        int[] answer = solution(prices);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j]){
                    answer[i]++;
                    break;
                } else {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}