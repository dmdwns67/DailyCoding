import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// DFS로 짜면 메모리 초과 납니다...ㅜㅜ BFS로 다시 짭시다
public class Main2 {
    static int N,M,minTime=Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][4];
        int sx=0, sy=0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                // S:1, C:2, #:-1, .:0
                char c = str.charAt(j);
                switch(c) {
                    case 'S':
                        map[i][j] = 1;
                        sx = i;
                        sy = j;
                        break;
                    case 'C':
                        map[i][j] = 2;
                        break;
                    case '#':
                        map[i][j] = -1;
                        for(int k=0;k<4;k++) visited[i][j][k] = true;
                        break;
                    case '.':
                        map[i][j] = 0;
                        break;
                }
            }
        }

        isPossible = false;
        dfs(sx, sy, 0, 0, -1, "", map, visited); // 현재 위치, C남은 갯수, visited 백트레킹, 최솟값 비교

        if(!isPossible) System.out.println(-1);
        else System.out.println(minTime);

        br.close();
    }

    public static void dfs(int x, int y, int c, int time, int prevDir, String test, int[][] originMap, boolean[][][] originVisited) {
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][4];
        map = copy2dArr(originMap, map);
        visited = copy3dArr(originVisited, visited);

        if(map[x][y] == 2) { // C를 찾았다면, param c 증가
            // System.out.println("(x,y): ("+x+","+y+"), time: " + time);
            c++;
            map[x][y] = 0;
        }

        if(c == 2) { // C를 2명 다 찾음
            // System.out.println(test + ", time: " +time);
            // System.out.println("(x,y): ("+x+","+y+"), time: " + time);
            minTime = Math.min(minTime, time);
            if(!isPossible) isPossible = true;
            return;
        }

        for(int i=0; i<4; i++) {
            if(prevDir != i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    if(!visited[nx][ny][i]) {
                        visited[nx][ny][i] = true;
                        dfs(nx,ny,c,time+1,i,test+"("+nx+","+ny+","+i+") ",map,visited);
                        visited[nx][ny][i] = false;
                    }
                }              
            }
        }
    }

    public static int[][] copy2dArr(int[][] ori, int[][] copy) {
        for(int i=0; i<ori.length; i++) {
            copy[i] = Arrays.copyOf(ori[i], ori[i].length);
        }
        return copy;
    }

    public static boolean[][][] copy3dArr(boolean[][][] ori, boolean[][][] copy) {
        for(int i=0; i<ori.length; i++) {
            copy[i] = new boolean[ori[i].length][];
            for(int j=0; j<ori[i].length; j++) {
                copy[i][j] = Arrays.copyOf(ori[i][j], ori[i][j].length);
            }
        }
        return copy;
    }
}
