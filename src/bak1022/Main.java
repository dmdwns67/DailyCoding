import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class Main {
    static int r1,c1,r2,c2, num;
    static int[][] map;
    static int[] dx = {0,-1,0,1}; // 우상좌하
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        
        map = new int[r2-r1+1][c2-c1+1];

        fill();
        print();

        br.close();
    }

    public static void print() {
        int b = (int)(Math.log10(num)+1);
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                int len = (int)(Math.log10(map[i][j])+1);
                for(int k=0; k<b-len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fill() {
        num = 1;
        int x=0, y=0, d=0, cnt=0, wCnt=0, dCnt=1;
        int size = (r2-r1+1) * (c2-c1+1);
        while(true) {
            if(wCnt >= size) {
                break;
            }

            if(r1<=x && x<=r2 && c1<=y && y<=c2) {
                map[x-r1][y-c1] = num;
                wCnt++;
            }   
            
            num++;  
            cnt++;  
            x += dx[d];
            y += dy[d];
                
            if(cnt == dCnt) {
                cnt = 0;
                if(d==1 || d==3) dCnt++;
                d = (d+1) % 4;
            }
        }
    }
}