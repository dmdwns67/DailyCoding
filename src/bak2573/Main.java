import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
    static int N,M;
    static int[][] map, melt;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

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

        int numOfIce = 1;
        int time = 0;
        while(true){
            numOfIce = calNumOfIce();

            // System.out.println("numOfIce: "+numOfIce);

            if(numOfIce >=2){
                break;
            } else if(numOfIce == 0) {
                time = 0;
                break;
            }

            checkMeltingAmount();

            // System.out.println("check melting");
            //  for(int i=0; i<N; i++){
            //      for(int j=0; j<M; j++){
            //          System.out.print(melt[i][j]+" ");
            //      }
            //      System.out.println();
            //  }

            MeltingIce();

            // System.out.println("after meltimg");
            //  for(int i=0; i<N; i++){
            //      for(int j=0; j<M; j++){
            //          System.out.print(map[i][j]+" ");
            //      }
            //      System.out.println();
            //  }

            time++;

            // System.out.println("time: "+time);
        }

        System.out.println(time);

        br.close();
    } 

    public static int calNumOfIce() {
        int num = 0;
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    num++;
                    bfs(i,j);
                }
            }
        }

        return num;
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] tmp= q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(!visited[nx][ny] && map[nx][ny] > 0){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }

    public static void checkMeltingAmount(){
        melt = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(map[i][j] !=0 && 0<=nx && nx<N && 0<=ny && ny<M){
                        if(map[nx][ny] == 0){
                            melt[i][j]++;
                        }
                    }
                }
            }
        }
    }

    public static void MeltingIce() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(melt[i][j] > 0){
                    map[i][j] -= melt[i][j];
                    if(map[i][j] < 0) map[i][j] = 0;
                }
            }
        }
    }
}