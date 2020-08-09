import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<i+1; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<i+1; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
            }
        }

        int max = Arrays.stream(dp[N]).max().getAsInt();
        System.out.println(max);

        sc.close();
    }
}