import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static ArrayList<Edge>[] dependency;
    static PriorityQueue<Edge> q;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for(int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 대수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dependency = new ArrayList[n+1];
            for(int k=1; k<n+1; k++){
                dependency[k] = new ArrayList<Edge>();
            } 

            for(int j=0; j<d; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                dependency[b].add(new Edge(a,s));  // b -> a 해킹
            }

            dijkstra(c);

            int cnt = 0;
            int maxDistance = 0;
            for(int sd : dist){
                if( sd != Integer.MAX_VALUE){
                    cnt++;
                    if(sd > maxDistance){
                        maxDistance = sd;
                    }
                }
            }

            System.out.println(cnt+ " " + maxDistance);
        }

        br.close();
    }

    public static void dijkstra(int c){
        q = new PriorityQueue<Edge>((Edge e1, Edge e2)->{
            return Integer.compare(e1.dist, e2.dist);
        });
        q.add(new Edge(c, 0));
        dist[c] = 0;

        while(!q.isEmpty()){
            Edge curr = q.poll();
            if(dist[curr.to] < curr.dist){
                continue;
            }
            for(Edge adj : dependency[curr.to]){
                int cost = adj.dist + dist[curr.to];
                if(dist[adj.to] > cost){
                    dist[adj.to] = cost;
                    q.add(new Edge(adj.to, cost));
                }
            }
        }
    }
}

class Edge {
    int to;
    int dist;

    public Edge(int to, int dist){
        this.to = to;
        this.dist = dist;
    }
}