import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    static boolean[][] map;
    static int I;
    static Point end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for(int t=0; t<tc; t++){
            I = sc.nextInt();
            map = new boolean[I][I];

            int sx = sc.nextInt();
            int sy = sc.nextInt();

            end = new Point(sc.nextInt(), sc.nextInt(), 0);
            
            bfs(sx, sy);
        }

        sc.close();
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y,0));
        map[x][y] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == end.x && p.y == end.y){
                System.out.println(p.dept);
                return;
            }

            for(int i=0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<=nx && nx<I && 0<=ny && ny<I){
                    if(!map[nx][ny]){
                        map[nx][ny] = true;
                        q.add(new Point(nx, ny, p.dept+1));
                    }
                }
            }
        }
    }
}

class Point {
    int x, y, dept;
    public Point(int x, int y, int dept){
        this.x = x;
        this.y = y;
        this.dept = dept;
    }
}