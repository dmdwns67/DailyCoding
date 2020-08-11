import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] chap = new int[K+1];
            for(int i=1; i<K+1; i++){
                chap[i] = Integer.parseInt(st.nextToken());
            }

            // sum[i] : 1번부터 i번까지의 누적합
            int[] sum = new int[K+1];
            for(int i=1; i<K+1; i++){
                sum[i] = sum[i-1] + chap[i];
            }
            
            // dp[i][j] : i에서 j까지 합하는데 필요한 최소 비용
            // dp[i][k] + dp[k+1][j] + sum(chap[i]~chap[j])
            int[][] dp = new int[K+1][K+1];
            for(int i=2; i<K+1; i++){ // 부분파일의 길이
                for(int j=1; j<K+2-i; j++){ // 시작점
                    int min = Integer.MAX_VALUE;
                    for(int k=0; k<i-1; k++){
                        min = Math.min(min, dp[j][j+k] + dp[j+k+1][j+i-1] + sum[j+i-1] - sum[j-1]); 
                    }
                    dp[j][j+i-1] = min;
                }
            }

            System.out.println(dp[1][K]);
        }

        br.close();
    }
}