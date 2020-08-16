import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1,0,1,0,0,0}; // 좌, 뒤, 우, 앞, 상, 하
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[][][] boxes = new int[H][N][M];
        Queue<Space> q = new LinkedList<>();
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    boxes[i][j][k] = sc.nextInt();
                    if(boxes[i][j][k] == 1) {
                        q.add(new Space(i, j, k));
                    }
                }
            }
        }

        int[][][] days = new int[H][N][M];
        while(!q.isEmpty()){
            Space s = q.poll();
            
            for(int i=0; i<6; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];
                int nz = s.z + dz[i];
                if(0<=nx && nx<H && 0<=ny && ny<N && 0<=nz && nz<M){
                    if(boxes[nx][ny][nz] == 0 && days[nx][ny][nz] == 0){
                        days[nx][ny][nz] = days[s.x][s.y][s.z] + 1;
                        q.add(new Space(nx, ny, nz));
                    }
                }
            }
        }

        boolean isPossible = true;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(boxes[i][j][k]==0 && days[i][j][k]==0){
                        isPossible = false;
                        break;
                    }
                }
                if(!isPossible) break;
            }
            if(!isPossible) break;
        }

        if(isPossible){
            int max=0;
            for(int i=0; i<H; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<M; k++){
                        max = Math.max(max, days[i][j][k]);
                    }
                }
            }
            System.out.println(max);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}

class Space{
    int x, y, z;
    public Space(int x, int y, int z) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}