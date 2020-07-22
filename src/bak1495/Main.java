import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] volumns = new int[N+1];
        volumns[0] = S;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<volumns.length; i++){
            volumns[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], 0);
        }

        dp[0][S] = 1;
        for(int i=1; i<N+1; i++){
            for(int j=0; j<M+1; j++){
                if(dp[i-1][j] == 0) continue;
                if(j - volumns[i] >= 0){
                    dp[i][j-volumns[i]] = 1;
                }
                if(j + volumns[i] <= M){
                    dp[i][j+volumns[i]] = 1;
                }
            }
        }
        /*
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        */

        int answer = -1;
        for(int i=M; i >= 0; i--){
            if(dp[N][i] == 1){
                answer = i;
                break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}