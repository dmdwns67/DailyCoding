import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static boolean[] visited;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1,1,0}
            ,{1,1,0}
            ,{0,0,1}
        };

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                check(i, computers);
                answer++;
            }
        }
        return answer;
    }

    public static void check(int c, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        visited[c] = true;
        q.add(c);
        while(!q.isEmpty()){
            int com = q.poll();
            for(int i=0; i<computers.length; i++){
                if(i == com) continue;
                if(computers[com][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}