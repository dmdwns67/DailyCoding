import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
	static StringTokenizer stk;
	static ArrayList<Integer>[] adj;	// 인접리스트, 속도 상 인접행렬 int[][]보다 낫다 카네
	static boolean[] visited;
	static Queue<Integer> Q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());	// 정점 수
		int M = Integer.parseInt(stk.nextToken());	// 간선 수 
		int V = Integer.parseInt(stk.nextToken());	// 시작 점
		
		// 정점개수에 따라 인접리스트 공간 할당
		adj = (ArrayList<Integer>[])new ArrayList[N+1];	// 각각 idx에 arrayList는 아직 공간 할당 안됨.
		for(int i=1; i<= N; i++){
			adj[i] = new ArrayList<Integer>();
		}
		
		// 간선 정보를 인접리스트에 저장
		for(int i=0; i<M; i++){
			String v[] = br.readLine().split(" ");
			adj[Integer.parseInt(v[0])].add(Integer.parseInt(v[1]));
			adj[Integer.parseInt(v[1])].add(Integer.parseInt(v[0]));
		}
		
		// 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것 먼저 방문해야 하므로 sort한다.
		for(int i=1; i<=N; i++) { Collections.sort(adj[i]);}	// modified mergesort인 듯
		
		// init visited[] and do DFS
		visited = new boolean[N+1];
		DFS(V);
		
		System.out.println();
		
		// reset visited[] and do BFS
		reset(N);
		Q = new LinkedList<Integer>();
		BFS(V);
		
		
	}
	
	public static void BFS(int v){
		visited[v] = true;	
		Q.add(v);	// start vertex 넣고!
		while(!Q.isEmpty()){
			int x = Q.poll();	// 빼고 지우기
			System.out.print(x + " ");
			for(int y : adj[x]){
				if(!visited[y]){
					Q.add(y);
					visited[y] = true;
				}
			}
		}
	}
	
	public static void DFS(int v){
		visited[v] = true;
		System.out.print(v + " ");
		for(int y : adj[v]){
			if(!visited[y]) DFS(y);
		}
	}
	
	public static void reset(int N){
		for(int i=1; i<=N; i++){
			visited[i] = false;
		}
	}
}