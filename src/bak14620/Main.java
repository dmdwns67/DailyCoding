import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 10000;
        for(int i=0; i<N*N; i++){
            for(int j=0; j<N*N; j++){
                for(int k=0; k<N*N; k++){
                    answer = Math.min(answer, calCost(i, j, k));
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static int calCost(int i, int j, int k){
        boolean[][] visited = new boolean[N][N];
    
        int cost = 0;
        int[] flowers = {i, j, k};
        for(int flower : flowers){
            int x = flower / N;
            int y = flower % N;
            if(x==0 || x==N-1 || y==0 || y==N-1){
                return 10000;
            }
            for(int d=0; d<5; d++){
                if(!visited[x+dx[d]][y+dy[d]]){
                    visited[x+dx[d]][y+dy[d]] = true;
                    cost += map[x+dx[d]][y+dy[d]];
                } else {
                    return 10000;
                }
            }
        }

        return cost;
    }
}