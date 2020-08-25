import java.util.PriorityQueue;

public class Solution {
    static int[] parent;
    static PriorityQueue<Line>  pq;
    public static void main(String[] args){
        int[][] costs = {
            {0,1,1},
            {0,2,2},
            {1,2,5},
            {1,3,1},
            {2,3,8}
        };
        int n = 4;

        int answer = solution(n, costs);

        System.out.println(answer);
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        pq = new PriorityQueue<>((i1,i2)->{
           return Integer.compare(i1.cost, i2.cost); 
        });
        for(int i=0; i<costs.length; i++){
            pq.add(new Line(costs[i][0],costs[i][1],costs[i][2]));
        }
        
        while(!pq.isEmpty()){
            Line line = pq.poll();
            
            if(find(line.a) == find(line.b)) continue;
            else {
                union(line.a, line.b);
                answer += line.cost;
            }
        }
        
        return answer;
    }
    
    public static int find(int n){
        if(parent[n] == n) {
            return n;
        } else {
            parent[n] = find(parent[n]);
            return parent[n];
        }
    }
    
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}

class Line {
    int a;
    int b;
    int cost;
    public Line(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}