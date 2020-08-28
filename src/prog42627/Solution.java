import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {
            {0,3},
            {1,9},
            {2,6}
        };

        int result = solution(jobs);

        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        // 먼저 들어오는 순서대로 정렬
        PriorityQueue<int[]> waitingList = new PriorityQueue<>((j1, j2) -> {
           return Integer.compare(j1[0], j2[0]); 
        });
        for(int i=0; i<jobs.length; i++){
            waitingList.add(new int[] {jobs[i][0], jobs[i][1]});
        }
        
        // 수행시간이 짧은거 먼저 꺼낼 것임.
        PriorityQueue<int[]> jobList = new PriorityQueue<>((j1, j2) -> {
           return Integer.compare(j1[1], j2[1]); 
        });
        
        int answer = 0;
        int jobCnt = 0;
        int time = waitingList.peek()[0];
        // 전체 job을 다 처리하면 반복문 종료
        while(jobCnt < jobs.length){
            // waitingList -> jobList 로 옮길 수 있는 job들은 죄다 이동
            while(!waitingList.isEmpty() && waitingList.peek()[0] <= time) {
                jobList.add(waitingList.poll());
            }
            
            // jobList에 있는 job 중 1개 처리
            if(!jobList.isEmpty()){
                int[] job = jobList.poll(); // 처리시간 가장 짧은 job
                time += job[1];
                answer += time - job[0]; // 전체 대기시간 누적합
                jobCnt++;
            } else {
                time++;
            }
        }
        
        return answer / jobCnt;
    }
}