import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,x,y;
    static int[][] map;
    static int[] dice;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cmd = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        dice = new int[6]; // default 0, d[0]: 바닥면, d[5]: 윗면
        for(int i=0; i<cmd.length; i++){
            int dir = cmd[i];
            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if(nx>=0 && ny>=0 && nx<N && ny<M){
                rolling(dir);
                
                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[0];
                } else {
                    dice[0] = map[nx][ny];
                    map[nx][ny] = 0;
                }

                System.out.println(dice[5]);

                x = nx;
                y = ny;
            }
        }


        br.close();
    }

    public static void rolling(int dir){
        int[] tmp = {};
        if(dice != null){
            tmp = Arrays.copyOf(dice, dice.length);
        }

        switch(dir){
            case 1: // 동
                dice[0] = tmp[2];
                dice[2] = tmp[5];
                dice[3] = tmp[0];
                dice[5] = tmp[3];
                break;
            case 2: // 서
                dice[0] = tmp[3];
                dice[2] = tmp[0];
                dice[3] = tmp[5];
                dice[5] = tmp[2];
                break;
            case 3: // 북
                dice[0] = tmp[1];
                dice[1] = tmp[5];
                dice[4] = tmp[0];
                dice[5] = tmp[4];
                break;
            case 4: // 남
                dice[0] = tmp[4];
                dice[1] = tmp[0];
                dice[4] = tmp[5];
                dice[5] = tmp[1];    
                break;
        }
    }
}