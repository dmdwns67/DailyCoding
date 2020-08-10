import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                arr[i][j] = sc.nextInt();
            }    
        }

        // 부분합 구현 : dp[i][j]은 (1,1)부터 (i,j)까지의 부분합
        int[][] dp = new int[N+1][M+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        int K = sc.nextInt();
        for(int i=0; i<K; i++){
            int I = sc.nextInt();
            int J = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            // dp[I-1][Y] : 윗 직사각형 부분, dp[X][J-1] : 좌측 직사각형 부분, dp[I-1][J-1] : 중복으로 빼버린 부분
            System.out.println(dp[X][Y]-dp[I-1][Y]-dp[X][J-1]+dp[I-1][J-1]);
        }

        sc.close();
    }
}