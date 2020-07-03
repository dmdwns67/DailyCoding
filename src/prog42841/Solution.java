import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[][] baseball = {
            {123,1,1},
            {356,1,0},
            {327,2,0},
            {489,0,1}
        };

        int answer = solution(baseball);

        System.out.println(answer);
    }

    public static int solution(int[][] baseball) {
        // Make a stack for candidate numbers
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                for(int k=1; k<10; k++){
                    if(i != j && j != k && k != i) {
                        stack.add(i*100 + j*10 + k);
                    }
                }
            }
        }

        Stack<Integer> temp = new Stack<Integer>();
        boolean flag = true;
        while(!stack.isEmpty()){
            int num = stack.pop();
            
            // check each condition in baseball[][]
            for(int i=0; i<baseball.length; i++){
                int strikeNum = calStrike(num, baseball[i][0]);
                int ballNum = calBall(num, baseball[i][0]) - strikeNum;
                if(strikeNum != baseball[i][1] || ballNum != baseball[i][2]){
                    flag = false;
                    break;
                }
            }

            if(flag) temp.add(num);

            flag = true;
        }

        return temp.size();
    }

    public static int calStrike(int num, int target){
        int cnt = 0;
        String numToStr = Integer.toString(num);
        String targetToStr = Integer.toString(target);
        for(int i=0; i< targetToStr.length(); i++){
            if(numToStr.charAt(i) == targetToStr.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }

    public static int calBall(int num, int target){
        int cnt = 0;
        String numToStr = Integer.toString(num);
        String targetToStr = Integer.toString(target);
        for(int i=0; i<targetToStr.length(); i++){
            if(numToStr.contains(Character.toString(targetToStr.charAt(i)))){
                cnt++;
            }
        }
        return cnt;
    }
}