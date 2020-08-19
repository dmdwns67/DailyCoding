import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int tc=0; tc<testCase; tc++){
            N = sc.nextInt();
            M = sc.nextInt();

            adj = new ArrayList[N+1];
            for(int i=0; i<N+1; i++){
                adj[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }

            visited = new boolean[N+1];
            int result = bfs();

            System.out.println(result);
        }

        sc.close();
    }

    public static int bfs() {
        int regions = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            Integer a = q.poll();
            regions++;
            for(Integer next : adj[a]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return regions-1; 
    }
}