public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long[] dp = new long[n];
        
        if(n == 1){
            return 1L;
        } else if(n == 2){
            return 2L;
        } else {
            dp[0] = 1;
            dp[1] = 2;
            for(int i=2; i<n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }
            
            return dp[n-1];
        }
    }
}