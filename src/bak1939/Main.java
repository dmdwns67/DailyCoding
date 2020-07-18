import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Bridge>> map = new HashMap<Integer, ArrayList<Bridge>>();

        int minWeight = 1000000000;
        int maxWeight = 1;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int island1 = Integer.parseInt(st.nextToken());
            int island2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(map.containsKey(island1)){
                map.get(island1).add(new Bridge(island2, weight));
            } else {
                ArrayList<Bridge> tmp = new ArrayList<Bridge>();
                tmp.add(new Bridge(island2, weight));
                map.put(island1, tmp);
            }

            if(map.containsKey(island2)){
                map.get(island2).add(new Bridge(island1, weight));
            } else {
                ArrayList<Bridge> tmp = new ArrayList<Bridge>();
                tmp.add(new Bridge(island1, weight));
                map.put(island2, tmp);
            }

            minWeight = Math.min(minWeight, weight);
            maxWeight = Math.max(maxWeight, weight);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int result = minWeight;
        while(minWeight <= maxWeight){
            int midWeight = (minWeight+maxWeight)/2;
            if(bfs(midWeight, map)){
                result = midWeight;
                minWeight = midWeight+1;
            } else {
                maxWeight = midWeight-1;
            }
        }

        System.out.println(result);

        br.close();
    }

    public static boolean bfs(int midWeight, HashMap<Integer, ArrayList<Bridge>> map){
        Queue<Integer> q = new LinkedList<Integer>();
        
        Boolean[] visited = new Boolean[N+1];
        Arrays.fill(visited, Boolean.FALSE);

        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int island = q.poll();
            for(Bridge adj : map.get(island)){
                if(!visited[adj.to] && adj.weight >= midWeight){
                    visited[adj.to] = true;
                    q.add(adj.to);
                }
            }
        }

        return visited[end];
    }
}

class Bridge {
    int to;
    int weight;
    public Bridge (int to, int weight){
        this.to = to;
        this.weight = weight;
    }    
}