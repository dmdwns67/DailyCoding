import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args){
        int n = 4;
        int[] works = {4,3,3};
        System.out.println(solution(n, works));
    }   

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2,i1));
        for(int i=0; i<works.length; i++) pq.add(works[i]);
        
        // 야근 안해도 일 다 끝낼 수 있음이 확실
        long sum = Arrays.stream(works).sum();
        if(sum <= n) return 0;

        while(true){
            Integer i = pq.poll();            
            
            if(i > 0 && n > 0){
                i--;
                pq.add(i);
                
                n--;
                sum--;
            }
            if(n==0) break; // 일이 남았지만 일할 수 있는 시간이 끝남
            if(sum==0) break; // 일을 다 해버림
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}