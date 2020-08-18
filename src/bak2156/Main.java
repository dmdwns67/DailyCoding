import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] juice = new int[N];
        int[] dp = new int[N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            juice[i] = Integer.parseInt(st.nextToken());
        }

        if(N==1) {
            System.out.println(juice[0]);
        } else if(N==2) {
            System.out.println(juice[0]+juice[1]);
        } else {
            dp[0] = juice[0];
            dp[1] = juice[0]+juice[1];
            dp[2] = Math.max(dp[1], Math.max(juice[0]+juice[2], juice[1]+juice[2]));

            for(int i=3; i<N; i++){
                dp[i] = Math.max(dp[i-3]+juice[i-1]+juice[i], Math.max(dp[i-2]+juice[i], dp[i-1]));
            }

            System.out.println(dp[N-1]);
        }
        
        br.close();
    }
}