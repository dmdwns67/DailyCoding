import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int R, C, result;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static boolean[] visited = new boolean[26]; // 알파벳 개수

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new int[R][C];
        for(int i=0; i<R; i++){
            String s = sc.next();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j) - 'A';
            }
        }

        result = 0;
        Arrays.fill(visited, false);
        bt(0,0,0);
        
        System.out.println(result);

        sc.close();
    }

    public static void bt(int x, int y, int dept){
        if(visited[map[x][y]]){
            result = Math.max(result, dept);
            return;
        } else {
            visited[map[x][y]] = true;
            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(0<=nextX && nextX < R && nextY >= 0 && nextY < C){
                    bt(nextX, nextY, dept+1);
                }
            }
            visited[map[x][y]]=false;
        }
    }
}