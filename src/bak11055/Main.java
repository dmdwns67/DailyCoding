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

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; /// dp[i]는 arr에서 i번까지 왔을 때 합의 최대값

        for(int i=0; i<arr.length; i++){
            dp[i] = arr[i];
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], arr[i]+dp[j]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        // for(int i : dp){
        //     System.out.print(i + " ");
        // }

        br.close();
    }
}