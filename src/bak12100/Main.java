import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;
	static int[][] Map;
	static int MAX = Integer.MIN_VALUE;
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> plusList = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		run();
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void run() throws IOException {
		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++){
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=4; i++) DFS(0, i, Map);
		bw.write(MAX+"\n");
	}
	
	public static void DFS(int count, int idx, int[][] map) {
		if(count == 5){
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					MAX = Math.max(MAX, map[i][j]);
				}
			}
			return;
		}
		
		int[][] nextMap = new int[N][N];
		
		for (int i=0; i<N; i++){
			list.clear();
			plusList.clear();
            // idx: 1=상, 2=하, 3=좌, 4=우
            // 상하로 움직일 때는 세로 줄 기준으로 움직이니까 [j][i]
            // 좌우로 움직일 때는 가로 줄 기준으로 움직이니까 그대로 [i][j]
            // plusList에서 꺼낼 때, 아래부터 또는 오른쪽부터 nextMap에 값을 넣으려면 list가 역순으로 되어있어야 함.
			if(idx==1){
				for(int j=0; j<N; j++){
					if(map[j][i] != 0) list.add(map[j][i]);
				}
			}
			if(idx==2){
				for(int j=0; j<N; j++){
					if(map[j][i] != 0) list.add(map[j][i]);
				}
				Collections.reverse(list);
			}
			if(idx==3){
				for(int j=0; j<N; j++){
					if(map[i][j] != 0) list.add(map[i][j]);
				}
			}
			if(idx==4){
				for(int j=0; j<N; j++){
					if(map[i][j] != 0) list.add(map[i][j]);
				}
				Collections.reverse(list);
			}
			
			for(int j=0; j<list.size(); j++){
				if(j < list.size()-1 && list.get(j).equals(list.get(j+1))){
					plusList.add(list.get(j)*2);
					j++;
				} else {
					plusList.add(list.get(j));
				}
			}
			
			for(int j=0; j<plusList.size(); j++){
                // 그림 그려보면, 상하좌우 순서로 값을 넣는 것임을 알 수 있음.
				if(idx == 1) nextMap[j][i] = plusList.get(j); // 좌상단부터 상->하 방향
				else if(idx == 2) nextMap[N-1-j][i] = plusList.get(j); // 좌하단부터 하->상 방향
				else if(idx == 3) nextMap[i][j] = plusList.get(j);  // 좌상단부터 좌->우 방향  
				else if(idx == 4) nextMap[i][N-1-j] = plusList.get(j); // 우상단부터 우->좌 방향
			}
		}
		
		for(int i=1; i<=4; i++) DFS(count+1, i, nextMap);
	}
}
