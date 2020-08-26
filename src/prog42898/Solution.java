public class Solution {
    public static void main(String[] args){
        int m = 5;
        int n = 3;
        int[][] puddles = {{4,2}};

        int answer = solution(m,n,puddles);

        System.out.println(answer);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];

        dp[1][1] = 1;
        
        boolean[][] water = new boolean[n+1][m+1]; // if false, can go through.
        for(int i=0; i<puddles.length; i++){
            water[puddles[i][1]][puddles[i][0]] = true; // if true, cannot go through.
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(water[i][j]) {
                    continue;
                }
                if(!water[i-1][j]){
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }
                if(!water[i][j-1]){
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }
        
        answer = dp[n][m] % 1000000007;
        
        return answer;
    }
}