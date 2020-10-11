import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][][][][] visited;
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][5][2][2]; // x,y,진입방향,c,d
        q = new LinkedList<Point>();
        boolean ctod = false; // 두개 C 중 1개를 D로 바꿈
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    visited[i][j][4][0][0] = true;
                    q.add(new Point(i,j,4,0,0));
                }
                if(!ctod && map[i][j] == 'C') {
                    ctod = true;
                    map[i][j] = 'D';
                } 
            }
        }

        int answer = bfs();

        System.out.println(answer);

        br.close();
    }

    public static int bfs() {
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                Point p = q.poll();
                // System.out.println("poll! " + p.toString());
                if(p.c == 1 && p.d == 1) { // 2개 다 찾았음
                    return time;
                }

                for(int i=0; i<4; i++) {
                    if(p.dir == i) continue;

                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx>=0 && ny>=0 && nx<N && ny<M 
                            && map[nx][ny] != '#' && !visited[nx][ny][i][p.c][p.d]) {
                        int isC = map[nx][ny]=='C'? 1 : 0;
                        int isD = map[nx][ny]=='D'? 1 : 0;    
                        if(p.d == 1) isD = 1;
                        if(p.c == 1) isC = 1;
                        visited[nx][ny][i][isC][isD] = true;
                        Point np = new Point(nx,ny,i,isC,isD);
                        // System.out.println("add: " + np.toString());
                        q.add(np);
                    }
                }
            }
            time++;
            // System.out.println("time is ticking: " + time);
        }
        return -1;
    }
}   

class Point {
    int x,y,dir,c,d;
    public Point(int x, int y, int dir, int c, int d) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "("+x+","+y+"), dir: " + dir +", c: " +c +", d: " +d;
    }
}
