import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] covered;
    static PriorityQueue<Position> cabbage;
    static ArrayList<Position> check;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        check = new ArrayList<Position>();
        check.add(new Position(-1, 0));
        check.add(new Position(0, -1));
        check.add(new Position(0, 1));
        check.add(new Position(1, 0));

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
    
            map = new int[M][N]; // default init value is 0
            covered = new boolean[M][N];
            for(int i=0; i<covered.length; i++){
                Arrays.fill(covered[i], Boolean.FALSE);
            }
    
            cabbage = new PriorityQueue<Position>((Position p1, Position p2) ->{
                if(p1.x != p2.x){
                    return Integer.compare(p1.x, p2.x);
                } else {
                    return Integer.compare(p1.y, p2.y);
                }
            });

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                cabbage.add(new Position(x,y));
            }
    
            int wormCnt=0;
            while(!cabbage.isEmpty()){
                Position p = cabbage.poll();
                //System.out.println("배추 꺼냈다!! (" + p.x + ", " + p.y + ")");
                if(!covered[p.x][p.y]){
                    //System.out.println("아직 커버가 안됐어!! 이 지점에 벌레를 풀자.");
                    dfs(p.x, p.y);
                    wormCnt++;
                }
            }

            System.out.println(wormCnt);
        }

        br.close();
    }

    public static void dfs(int x, int y){
        covered[x][y] = true;
        //System.out.println("커버된 지점: (" + x + ", " + y + ")");
        for(Position next : check){
            int nextX = x + next.x;
            int nextY = y + next.y;
            if(nextX >= 0 && nextX < M &&
                nextY >= 0 && nextY < N &&
                !covered[nextX][nextY] && map[nextX][nextY] == 1){
                    dfs(nextX, nextY);
                }
        }
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}