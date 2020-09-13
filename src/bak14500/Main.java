import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N,M,answer;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                checkExceptionBlock(i,j);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int x, int y, int cnt, int sum) {
        if( cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M
                && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx,ny,cnt+1,sum+map[nx][ny]);
                    visited[nx][ny] = false;
                }

        }
    }

    // ㅏ, ㅗ, ㅜ, ㅓ
    public static void checkExceptionBlock(int x, int y) {
        int sum = 0;
        // ㅏ
        if(x-1>=0 && x+1<N && y+1<M ) {
            sum = map[x][y] + map[x-1][y] + map[x][y+1] + map[x+1][y];
            answer = Math.max(answer, sum);
        }

        // ㅗ
        if(x-1>=0 && y-1>=0 && y+1<M ) {
            sum = map[x][y] + map[x][y-1] + map[x][y+1] + map[x-1][y];
            answer = Math.max(answer, sum);
        }

        // ㅜ
        if(y-1>=0 && y+1<M && x+1<N ) {
            sum = map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y];
            answer = Math.max(answer, sum);
        }

        // ㅓ
        if(x-1>=0 && x+1<N && y-1>=0 ) {
            sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
            answer = Math.max(answer, sum);
        }
    }
}
