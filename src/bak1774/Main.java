import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Point[] locations;
    static ArrayList<Edge> edges;
    static int[] parent;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        locations = new Point[N+1];
        edges = new ArrayList<Edge>();
        parent = new int[N+1];
        
        for(int i=1; i<N+1; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            locations[i] = new Point(x,y);
        }

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        for(int i=1; i<N; i++){
            for(int j=i+1; j<N+1; j++){
                edges.add(new Edge(i, j, getDistance(locations[i], locations[j])));
            }
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(parent, a, b);
        }

        Collections.sort(edges, (Edge e1, Edge e2)->{
            return Double.compare(e1.dist, e2.dist);
        });

        double result = 0;
        for(Edge edge : edges){
            //System.out.println("EDGE: ("+edge.x+ ", "+edge.y+"), distance: "+edge.dist);
            if(!findParent(parent, edge.a, edge.b)){
                //System.out.println("connected");
                unionParent(parent, edge.a, edge.b);
                result += edge.dist;
            }
        }

        System.out.println(String.format("%.2f", result));

        sc.close();
    }

    public static double getDistance(Point p1, Point p2){
        int a = p1.x - p2.x;
        int b = p1.y - p2.y;
        //return Math.sqrt((a*a) + (b*b)); -> int 형 범위 넘어갈 수도 있어서 Math.pow 사용
        return Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
    }

    public static int getParent(int[] parent, int n){
        if(parent[n] == n) return n;
        
        return getParent(parent, parent[n]);
    }

    public static void unionParent(int[] parent, int a, int b){
        int pa = getParent(parent, a);
        int pb = getParent(parent, b);
        if(pa < pb){
            parent[pb] = pa;
        } else if (pa > pb){
            parent[pa] = pb;
        }
    }

    public static boolean findParent(int[] parent, int a, int b){
        int pa = getParent(parent, a);
        int pb = getParent(parent, b);
        if(pa==pb) return true;
        else return false;
    }
}

class Point {
    int x; 
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Edge {
    int a;
    int b;
    double dist;
    public Edge(int a, int b , double dist){
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}