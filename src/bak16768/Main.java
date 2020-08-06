import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int K, N;
    static int[][] map;
    static boolean[][] chk, chk2;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][10];
        for(int i=0; i<N; i++){
            String raw = sc.next();
            for(int j=0; j<10; j++){
                map[i][j] = raw.charAt(j) - '0';
            }
        }

        boolean isChange = true;
        while(true){
            isChange = false;
            chk = new boolean[N][10];
            chk2 = new boolean[N][10];
            for(int i=0; i<N; i++){
                for(int j=0; j<10; j++){
                    if(map[i][j] == 0 || chk[i][j]){
                        continue;
                    }
                    int res = dfs(i, j); // count the number of mooyo mooyo
                    if(res >= K){
                        dfs2(i,j, map[i][j]);  // delete mooyo mooyo 
                        isChange = true;
                    }
                }
            }

            if(!isChange) break;
            
            down();
        }        

        for(int i=0; i<N; i++){
            for(int j=0; j<10; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }

    public static int dfs(int x, int y){
        chk[x][y] = true;
        int cnt = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=N || ny < 0 || ny >=10){
                continue;
            }
            if(chk[nx][ny] || map[x][y] != map[nx][ny]){
                continue;
            }
            cnt += dfs(nx, ny);
        }
        return cnt;
    }

    public static void dfs2(int x, int y, int value){
        chk2[x][y] = true;
        map[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=N || ny < 0 || ny >=10){
                continue;
            }
            if(chk2[nx][ny] || map[nx][ny] != value){
                continue;
            }
            dfs2(nx, ny, value);
        }
    }

    public static void down() {
        for(int i=0; i<10; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0; j<N; j++){
                if(map[j][i] != 0){
                    tmp.add(map[j][i]);
                }
            }
            for(int j=0; j<N-tmp.size(); j++){
                map[j][i] = 0;
            }
            for(int j=N-tmp.size(); j<N; j++){
                map[j][i] = tmp.get(j-N+tmp.size());
            }
        }
    }
}