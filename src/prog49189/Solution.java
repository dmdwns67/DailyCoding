import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] level;
    public static void main(String[] args){
        int n = 6;
        int[][] vertex = {
          {3,6}
          ,{4,3}
          ,{3,2}
          ,{1,3}
          ,{1,2}
          ,{2,4}
          ,{5,2}  
        };

        int answer = solution(n, vertex);

        System.out.println(answer);
    }

    public static int solution(int n, int[][] edge) {
        adj = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new ArrayList<Integer>();        
        
        for(int i=0; i<edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        
        visited = new boolean[n+1];
        level = new int[n+1]; // depth를 저장할 것임
        
        bfs();
        
        int max = Arrays.stream(level).max().getAsInt();
        int answer = (int)Arrays.stream(level).filter(i -> i == max).count();
        
        return answer;
    }
    
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1,0}); // [0] idx, [1] depth
        visited[1] = true;
        level[1] = 0;
        
        while(!q.isEmpty()){
            int[] i = q.poll();
            for(int next : adj[i[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    level[next] = i[1]+1;
                    q.add(new int[] {next, i[1]+1});
                }
             }   
        }
    }
}