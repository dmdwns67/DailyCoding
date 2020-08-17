import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int M = sc.nextInt();

        adj = (ArrayList<Integer>[])new ArrayList[N+1];	
        for(int i=1; i<=N; i++){
			adj[i] = new ArrayList<Integer>();
		}
		
		// 촌수 정보를 인접리스트에 저장
		for(int i=0; i<M; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        
        bfs(start, end);

        if(answer[end] == 0){
            System.out.println(-1);
        } else {
            System.out.println(answer[end]);
        }

        sc.close();
    }

    public static void bfs(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            Integer v = q.poll();

            if(v == e) break;
            
            for(int i : adj[v]) {
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    answer[i] = answer[v] + 1;
                }
            }
        }
    }
}