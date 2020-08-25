public class Solution {
    public static void main(String[] args){
        int n = 4;

        int answer = solution(n);

        System.out.println(answer);
    }

    public static int solution(int n){
        int[] dp = new int[n+1];
        
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else {
            dp[1]=1;
            dp[2]=2;
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i-2] + dp[i-1])%1000000007;
            }
            
            return dp[n];   
        }
    }
}