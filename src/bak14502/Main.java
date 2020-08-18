import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxSafeZoneCnt=0;
    static int[][] map, simulMap;
    static List<Space> virusList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virusList = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virusList.add(new Space(i,j));
                }
            }
        }

        simulation(0,0);

        System.out.println(maxSafeZoneCnt);

        br.close();
    }

    // map을 완전탐색하면서 벽 3개일 경우 안전지대 최대 갯수 갱신 
    public static void simulation(int idx, int wall) {
        if(wall == 3){
            // copy current map to simulation map for testing spreading virus
            simulMap = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    simulMap[i][j] = map[i][j];
                }
            }

            // spread virus
            for(Space virus : virusList){
                dfs(virus.x, virus.y);
            }

            // get safe zone value
            int safeZoneCnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(simulMap[i][j] == 0) safeZoneCnt++;
                }
            }
            maxSafeZoneCnt = Math.max(maxSafeZoneCnt, safeZoneCnt);

            return;
        }

        // back tracking 활용해서 벽을 3개 세웠을 모든 경우 탐색
        for(int i=idx; i<N*M; i++){
            int x = i / M;
            int y = i % M;

            if(map[x][y] == 0){
                map[x][y] = 1;
                simulation(i+1, wall+1);
                map[x][y] = 0;
            }
        }
    }

    // dfs로 simulMap에 바이러스 퍼뜨려보기
    public static void dfs(int x, int y){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<N && 0<=ny && ny<M){
                if(simulMap[nx][ny] == 0) {
                    simulMap[nx][ny] = 2;
                    dfs(nx,ny);
                }
            }
        }
    }
}

class Space {
    int x, y;
    public Space(int x, int y) {
        this.x = x;
        this.y = y;
    }
}