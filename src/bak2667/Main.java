import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visitied;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        visitied = new boolean[N][N];

        for(int i=0; i< N; i++){
            String str = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && visitied[i][j] == false){
                    cnt = 0;
                    dfs(i, j);
                    //System.out.println("(i,j): (" +i+","+j+") and cnt: "+cnt );
                    answer.add(cnt);
                }
            }
        }
        
        Collections.sort(answer);

        System.out.println(answer.size());
        for(Integer i : answer){
            System.out.println(i);
        }

        sc.close();
    }

    public static void dfs(int x, int y){
        visitied[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx <N && ny >=0 && ny <N
                && !visitied[nx][ny] && map[nx][ny] == 1){
                    dfs(nx, ny);
                }
        }
    }
    
}