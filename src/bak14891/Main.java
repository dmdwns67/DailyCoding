import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Main {
    static int[][] gears;
    static boolean[] turnFlag, checked;
    static int[] dirFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        gears = new int[5][8];
        for(int i=1; i<5; i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<c.length; j++) {
                gears[i][j] = c[j] - '0';
            }
        }

        turnFlag = new boolean[5];
        dirFlag = new int[5];
        checked = new boolean[5];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            String[] cmd = br.readLine().split(" "); // [0]: gear# , [1]: direction
            int gear = Integer.parseInt(cmd[0]);
            int direction = Integer.parseInt(cmd[1]);

            initState();

            turnFlag[gear] = true;
            dirFlag[gear] = direction;
            checked[gear] = true;
            checkAdjGear(gear, direction);

            for(int j=1; j<5; j++){
                if(turnFlag[j]){
                    turnGear(j, dirFlag[j]);
                }
            }
        }

        int sum = 0;
        for(int i=1, num=0; i<5; i++, num++){
            if(gears[i][0] == 0) continue;

            sum += Math.pow(2, num);
        }

        System.out.println(sum);

        br.close();
    }

    public static void initState() {
        Arrays.fill(turnFlag, false);
        Arrays.fill(dirFlag, 0);
        Arrays.fill(checked, false);
    }

    public static void checkAdjGear(int n, int dir){
        if(n < 1 || n >=5) return;

        if(n-1 >= 1 && !checked[n-1]){
            checked[n-1] = true;
            if(gears[n-1][2] != gears[n][6]){
                turnFlag[n-1] = true;
                dirFlag[n-1] = (-1)*dir;
                checkAdjGear(n-1, (-1)*dir);
            }
        }

        if(n+1 < 5 && !checked[n+1]) {
            checked[n+1] = true;
            if(gears[n+1][6] != gears[n][2]) {
                turnFlag[n+1] = true;
                dirFlag[n+1] = (-1)*dir;
                checkAdjGear(n+1, (-1)*dir);
            }
        }
    }

    public static void turnGear(int n, int dir) {
        int[] tmp = Arrays.copyOf(gears[n], gears[n].length);

        switch(dir) {
            case 1: // 시계
                for(int i=0; i<8; i++) {
                    gears[n][i] = tmp[(7+i)%8];
                }
                break;
            case -1: // 반시계
                for(int i=0; i<8; i++) {
                    gears[n][i] = tmp[(i+1)%8];
                }    
                break;
        }
    }
}