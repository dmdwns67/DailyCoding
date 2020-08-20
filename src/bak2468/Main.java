import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Integer N;
    static Integer[][] map;
    static boolean[][] water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new Integer[N][N];
        int maxVal = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(maxVal, map[i][j]);
            }
        }

        int answer = 0;
        for(int k=1; k<=maxVal; k++){
            water = new boolean[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(water[i], false);
            }

            int safezone = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]>=k && !water[i][j]){
                        safezone++;
                        dfs(i,j,k);
                    } 
                }
            }
            answer = Math.max(answer, safezone);
        }

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int x, int y, int h) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        water[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(!water[nx][ny] && map[nx][ny]>=h){
                    dfs(nx,ny,h);
                }
            }
        }

    }
}