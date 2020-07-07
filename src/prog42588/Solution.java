import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        int[] heights = {6,9,5,7,4};

        int[] answer = solution(heights);

        for(int num : answer){
            System.out.print(num + " ");
        }
    }   

    public static int[] solution(int[] heights){
        int[] answer = new int[heights.length];
        
        Stack<Integer> tower = new Stack<Integer>();
        for(int i=0; i<heights.length; i++){
            tower.push(heights[i]);
        }
        
        while(!tower.isEmpty()){
            int sender = tower.pop();
            
            for(int i=tower.size(); i>=0; i--){
                if(sender < heights[i]){
                    answer[tower.size()] = i+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}