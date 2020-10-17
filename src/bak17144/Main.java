import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T,airCleaner;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        boolean cleanerFound = false;
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1 && !cleanerFound) {
                    airCleaner = i;
                    cleanerFound = true;
                }
                map[i][j] = tmp;
            }
        }

        for(int i=0; i<T; i++) {
            spreadDust();

            operateCleaner();

            // printTest(i);
        }

        printRemainDust();

        br.close();
    }

    public static void printTest(int t) {
        System.out.println("TIME: " + t);
        for(int i=0; i<R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }  
        System.out.println();
    }

    public static void printRemainDust() {
        int sum = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static void spreadDust() {
        Queue<Square> dusts = new LinkedList<>();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] != -1 && map[i][j] != 0) {
                    dusts.add(new Square(i, j, map[i][j]));
                }
            }
        }

        while(!dusts.isEmpty()) {
            Square dust = dusts.poll();

            if(dust.val < 5) continue;

            int spreadingDust = dust.val / 5;
            int count = 0;
            for(int i=0; i<4; i++) {
                int nx = dust.x + dx[i];
                int ny = dust.y + dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C) {
                    if(map[nx][ny] == -1) continue;
                    map[nx][ny] += spreadingDust;
                    count++;
                }
            }

            map[dust.x][dust.y] -= spreadingDust*count;
        }
    }

    public static void operateCleaner() {
        int top = airCleaner;
        for(int i = top-1; i>0; i--) { // 왼쪽 변, 위에서 아래로
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<C-1; i++) { // 상단 변, 오른쪽에서 왼쪽으로
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<top; i++) { // 오른쪽 변, 아래에서 위로
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--) { // 하단 변, 왼쪽에서 오른쪽으로
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0; // 공기청정기에서 나온 바람은 먼지 없음.

        int bottom = airCleaner+1;
        for(int i=bottom+1; i<R-1; i++) { // 왼쪽 변, 아래에서 위로
            map[i][0] = map[i+1][0];
        }
        for(int i=0; i<C-1; i++) { // 하단 변, 오른쪽에서 왼쪽으로
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1; i>bottom; i--) { // 오른쪽 변, 위에서 아래로
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--) { // 상단 변, 왼쪽에서 오른쪽으로
            map[bottom][i] = map[bottom][i-1];
        }
        map[bottom][1] = 0; // 공기청정기에서 나온 바람은 먼지 없음.
    }
}

class Square {
    int x, y, val;
    public Square(int x, int y, int val) {
        this.x = x; 
        this.y = y;
        this.val = val;
    }
}
