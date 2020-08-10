import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<N+1; i++) {
            String[] str = br.readLine().split("");
            for(int j=1; j<M+1; j++){
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        int max = 0;
        int[][] dp = new int[N+1][M+1]; 
        // dp[i][j] = (i,j)가지 왔을 때, 가장 큰 정사각형의 한 변의 길이
        // dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(arr[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // for(int i=0; i<N+1; i++){
        //     for(int j=0; j<M+1; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(max * max);

        br.close();
    }
}