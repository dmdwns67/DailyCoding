import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        for(int i = 1; i < n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j]){
                   dp[i] = Math.max(dp[j] + 1, dp[i]);
                   max = Math.max(dp[i], max);
                }
            }
        }

        int len = max;
        Stack<Integer> stack = new Stack<>();
        for(int i=n; i > 0; i--){
            if(len == dp[i]) {
                stack.push(arr[i]);
                len--;
            }
        }
        
        System.out.println(max);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

        br.close();
     }
}