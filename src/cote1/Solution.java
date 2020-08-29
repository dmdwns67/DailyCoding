import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        int N = 3;
        int[][] data= {
            {0,4},{2,3},{2,4},{2,5}
        };
        System.out.println(solution(N, data));

        N = 1;
        int[][] data2 = {
            {2,3},{5,4},{6,3},{7,4}
        };
        System.out.println(solution(N, data2));

    }

    public static int solution(int N, int[][] data) {
        Queue<int[]> waiting = new LinkedList<>();
        for(int i=0; i<data.length; i++){
            waiting.add(new int[] {data[i][0], data[i][1]});
        }
        
        int answer = 0;
        PriorityQueue<Desk> desks = new PriorityQueue<>((d1,d2) -> {
            return Integer.compare(d1.endTime, d2.endTime);
        }); // 가장 빨리 끝난 시간 기준
        for(int i=0; i<N; i++){
            desks.add(new Desk(i, 0));
        }
        while(!waiting.isEmpty()){
            int[] person = waiting.poll(); // [0]: 도착시간, [1]: 소요시간
            Desk target = desks.poll();
            int nextTime = target.endTime;
            if(nextTime <= person[0]){
                nextTime = person[0] + 1;
            } else {
                answer += nextTime - person[0] -1;
            }
            nextTime += person[1];
            desks.add(new Desk(target.idx, nextTime));
        }
        
        return answer;
    }
}

class Desk {
    int idx, endTime;
    public Desk(int idx, int endTime){
        this.idx = idx;
        this.endTime = endTime;
    }
}

// N	simulation_data	result
// 2	[[0, 3], [2, 5], [4, 2], [5, 3]]	1
// 1	[[2, 3], [5, 4], [6, 3], [7, 4]]	8