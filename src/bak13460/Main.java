import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int rx,ry,bx,by;
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                char c = line[j];
                int val = 0;
                switch(c) {
                    case '#':
                        val = -1;
                        break;
                    case '.':
                        val = 0;
                        break;
                    case 'R':
                        val = 1;
                        rx = i;
                        ry = j;
                        break;
                    case 'B':
                        val = 2;
                        bx = i;
                        by = j;
                        break;
                    case 'O':
                        val = 3;
                        break;
                }
                map[i][j] = val;
            }
        }

        visited = new boolean[N][M][N][M]; 
        int answer = bfs();
        System.out.println(answer);

        br.close();
    }

    public static int bfs() {
        Queue<State> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()){
            State s = q.poll();
            if(s.cnt > 10) continue;
            if(map[s.bx][s.by] == 3) continue;
            if(map[s.rx][s.ry] == 3) return s.cnt;

            for(int i=0; i<4; i++){
                // 빨간 구슬을 상하좌우로 기울였을 때 더 이상 움직이지 못할 때까지 이동
                int nrx = s.rx;
                int nry = s.ry;
                while(true) {
                    if(map[nrx][nry] != -1 && map[nrx][nry] != 3) {
                        nrx += dx[i];
                        nry += dy[i];
                    } else {
                        if(map[nrx][nry] == -1) {
                            nrx -= dx[i];
                            nry -= dy[i];
                        }
                        break;
                    }
                }

                // 파란 구슬을 상하좌우로 기울였을 때 더 이상 움직이지 못할 때까지 이동
                int nbx = s.bx;
                int nby = s.by;
                while(true) {
                    if(map[nbx][nby] != -1 && map[nbx][nby] != 3) {
                        nbx += dx[i];
                        nby += dy[i];
                    } else {
                        if(map[nbx][nby] == -1) {
                            nbx -= dx[i];
                            nby -= dy[i];
                        }
                        break;
                    }
                }

                // 빨간, 파란 구슬이 같은 지점에 있는지 체크해도 위치 수정.
                if(nrx == nbx && nry == nby) {
                    if(map[nrx][nry] != 3){ // 구멍이 아닌 경우
                        int redDistance = Math.abs(nrx - s.rx) + Math.abs(nry - s.ry);
                        int blueDistance = Math.abs(nbx - s.bx) + Math.abs(nby - s.by);
                        if(redDistance > blueDistance) {
                            nrx -= dx[i];
                            nry -= dy[i];
                        } else {
                            nbx -= dx[i];
                            nby -= dy[i];
                        }
                    } else if(map[nrx][nry] == 3) { // 구멍인 경우
                        continue;
                    }
                 }

                 // 다음 상태가 방문한 적이 없다면 큐에 상태를 추가
                 if(!visited[nrx][nry][nbx][nby]){
                     visited[nrx][nry][nbx][nby] = true;
                     q.add(new State(nrx,nry,nbx,nby,s.cnt+1));
                 }
            } // end of for loop
        } // end of while loop

        return -1;
    }
}

class State {
    int rx,ry,bx,by,cnt;
    public State(int rx, int ry, int bx, int by, int cnt){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}