import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M, Cheese;
    static int[][] map;
    static boolean[][] melt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Cheese = 0;
        map = new int[N][M];
        melt = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    Cheese++;   // 치즈 개수
                }
            }
        }

        int priorCheese = 0;    // 이전 치즈 저장
        int time = 0;           // 녹는 시간 체크
        while(Cheese != 0){
            priorCheese = Cheese;   
            time++;

            melting();

            removeCheese();
        }

        System.out.println(time);
        System.out.println(priorCheese);

        br.close();
    }

    // 치즈 내부 구멍은 무시하고 melt 값 갱신
    public static void melting(){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        melt[0][0] = true;
        q.add(new int[] {0,0});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(!visited[nx][ny] && map[nx][ny] != 1){   // 방문한 적 없고, 치즈가 아니면
                        visited[nx][ny] = true;     // 방문 상태로 변경
                        melt[nx][ny] = true;        // melt 값 true로 변경
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    public static void removeCheese() {
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(isEdge(i,j)){
                    visited[i][j] = true;   // 지울 대상임을 체크.
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]){
                    if(map[i][j] == 1){ // 지울 대상이고, 동시에 치즈라면 melt.
                        Cheese--;
                    }
                    map[i][j] = 0;
                    melt[i][j] = true; // 다음 번에 외부 공기와 맞닿을테니까 true.
                }
            }
        }
    }

    public static boolean isEdge(int i, int j){
        
        for(int k=0; k<4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(0<=nx && nx<N && 0<=ny && ny<M){
                if(melt[nx][ny] == true){   // 외부 공기와 맞닿아 있다는 의미지.
                    return true;
                }
            }
        }
        return false;
    }
}