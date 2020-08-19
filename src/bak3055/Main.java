import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Integer R,C,minTime;
    static Queue<Tile> floodList, beaverList;
    static char[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        floodList = new LinkedList<>();
        beaverList = new LinkedList<>();
        map = new char[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '*'){
                    floodList.add(new Tile(i,j));
                } else if(map[i][j] == 'S') {
                    beaverList.add(new Tile(i,j));
                } 
            }
        }

        flooding();

        br.close();
    }

    public static void flooding() {
        minTime = 0;
        while(true){
            minTime++;
            if(beaverList.size() == 0){
                System.out.println("KAKTUS");
                return;
            }

            moveWater();
            if(isGoal()){
                System.out.println(minTime);
                return;
            }
        }
    }

    public static boolean isGoal(){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int cnt = beaverList.size();

        for(int i=0; i<cnt; i++){
            Tile beaver = beaverList.poll();
            for(int j=0; j<4; j++){
                int nx = beaver.x +dx[j];
                int ny = beaver.y +dy[j];
            
                if(0<=nx && nx<R && 0<=ny && ny<C){
                    if(map[nx][ny] == 'D') {
                        return true;
                    }
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        beaverList.add(new Tile(nx,ny));
                    }
                }
            }
        }
        return false;
    }

    public static void moveWater() {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int cnt = floodList.size();

        for(int i=0; i<cnt; i++){
            Tile water = floodList.poll();
            for(int j=0; j<4; j++){
                int nx = water.x +dx[j];
                int ny = water.y +dy[j];
            
                if(0<=nx && nx<R && 0<=ny && ny<C){
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        floodList.add(new Tile(nx,ny));
                    }
                }
            }
        }

    }
}

class Tile {
    int x, y;
    public Tile(int x, int y){
        this.x = x;
        this.y = y;
    }
}
