import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] triangle = {
            {7},{3,8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}
        };
        
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int n = triangle.length;
        
        if(n==1) return triangle[0][0];
        
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(dp[i-1][j] != -1){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                if(j-1 >= 0 && dp[i-1][j-1] != -1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + triangle[i][j]);
                }
            }
        }
        
        int maxVal = Arrays.stream(dp[n-1]).max().getAsInt();
        
        return maxVal;
    }
}