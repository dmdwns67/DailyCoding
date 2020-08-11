import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * 0 : 정보과학관
         * 1 : 전산관
         * 2 : 미래관
         * 3 : 신앙관
         * 4 : 한경직
         * 5 : 진리관
         * 6 : 학생회관
         * 7 : 형남공학관
         * dp : 0분에 어떤 지점에 도착할 수 있는 상태
         */
        long[] dp = {1,0,0,0,0,0,0,0};

        int D = sc.nextInt();

        for(int i=0; i<D; i++){
            dp = next(dp);
            //print(dp);
        }

        System.out.println(dp[0]);

        sc.close();
    }

    public static long[] next(long[] state) {
        // 일종의 점화식
        long[] tmp = new long[8];
        tmp[0] = state[1] + state[2];
        tmp[1] = state[0] + state[2] + state[3];
        tmp[2] = state[0] + state[1] + state[3] + state[4];
        tmp[3] = state[1] + state[2] + state[4] + state[5];
        tmp[4] = state[2] + state[3] + state[5] + state[7];
        tmp[5] = state[3] + state[4] + state[6];
        tmp[6] = state[5] + state[7];
        tmp[7] = state[4] + state[6];
        for(int i=0; i<8; i++){
            tmp[i] %= 1000000007;
        }

        return tmp;
    }

    public static void print(long[] dp){
        for(int i=0; i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

}