import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static ArrayList<Node>[] reverseAdj;
    static boolean[][] dropped;
    static int[] distance;
    static int start, end;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n+1];
            for(int i=0; i<n+1; i++){
                adj[i] = new ArrayList<Node>();
            }
            reverseAdj = new ArrayList[n+1];
            for(int i=0; i<n+1; i++){
                reverseAdj[i] = new ArrayList<Node>();
            }

            for(int i=0;i <m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adj[x].add(new Node(y, cost));
                reverseAdj[y].add(new Node(x, cost));
            }

            dropped = new boolean[n+1][n+1];
            for(int i=0; i<n+1; i++){
                Arrays.fill(dropped[i], Boolean.FALSE);
            }
            distance = new int[n+1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            dijkstra();
            bfs();

            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra();

            if(distance[end] != Integer.MAX_VALUE){
                System.out.println(distance[end]);
            } else {
                System.out.println(-1);
            }
        }

        br.close();
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((Node n1, Node n2)->{
            return Integer.compare(n1.dist, n2.dist);
        });
        pq.add(new Node(start, 0));
        distance[start]=0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(distance[curr.idx] < curr.dist) continue;
            for(Node adj : adj[curr.idx]){
                int cost = curr.dist + adj.dist;
                if(distance[adj.idx] > cost && !dropped[curr.idx][adj.idx]){
                    distance[adj.idx] = cost;
                    pq.add(new Node(adj.idx, cost));
                }
            }
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(end);
        while(!q.isEmpty()){
            int curr = q.poll();
            if (curr == start){
                continue;
            }
            for(Node adj : reverseAdj[curr]){
                if(distance[curr] == (distance[adj.idx] + adj.dist) ){
                    dropped[adj.idx][curr] = true;
                    q.add(adj.idx);
                }
            }
        }
    }
}

class Node {
    int idx; 
    int dist;

    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}