import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> adj;
    static boolean[] visited;
    static Queue<Integer> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        adj = new HashMap<Integer, ArrayList<Integer>>();

        for(int i=0; i<M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            ArrayList<Integer> arr;
            if(adj.get(from) == null) {
                arr = new ArrayList<Integer>();
            } else {
                arr = adj.get(from);
            }
            arr.add(to);
            adj.put(from, arr);

            if(adj.get(to) == null) {
                arr = new ArrayList<Integer>();
            } else {
                arr = adj.get(to);
            }
            arr.add(from);
            adj.put(to, arr);
        }

        for(ArrayList<Integer> tmp : adj.values()){
            Collections.sort(tmp);
        }

        visited = new boolean[N+1];
        Arrays.fill(visited, Boolean.FALSE);
        dfs(V);

        System.out.println();

        Arrays.fill(visited, Boolean.FALSE);
        q = new LinkedList<Integer>();
        q.add(V);
        bfs(V);

        sc.close();
    }

    public static void dfs(int v){
        System.out.print(v + " ");
        visited[v] = true;
        if(adj.get(v) != null){
            for(int node : adj.get(v)){
                if(!visited[node]){
                    dfs(node);
                }
            }
        }
    }

    public static void bfs(int v){
        while(!q.isEmpty()){
            int node = q.poll();
            if(!visited[node]){
                visited[node] = true;
                System.out.print(node +" ");
                if(adj.get(node) != null){
                    for(int i : adj.get(node)){
                        if(!visited[i]){
                            q.add(i);
                        }
                    }
                }
            }
        }
    }
}