import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args){
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        int[] answer = solution(progresses, speeds);

        for(int num : answer){
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> periods = new LinkedList<Integer>();

        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            int period = (100-progresses[i])%speeds[i] == 0 ? day : day + 1;

            periods.add(period);
        }

        List<Integer> result = new ArrayList<Integer>();

        while(!periods.isEmpty()){
            int period = periods.poll();
            int cnt = 1;

            while(!periods.isEmpty() && period >= periods.peek()){
                periods.poll();
                cnt++;
            }

            result.add(cnt);
        }

        int[] answer = new int[result.size()];
        int idx = 0;
        for(int num : result){
            answer[idx++] = num;
        }

        return answer;
    }
    
}