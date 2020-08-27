import java.util.Arrays;

public class Solution {
    static final int NUMBER = 1000000007;

    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};

        int result = solution(n, money);

        System.out.println(result);
    }

    public static int solution(int n, int[] money) {
        Arrays.sort(money);
        
        int[] dp = new int[n+1];
        
        dp[0] = 1; // n % money[i] 이 0인 경우 처리
        for(int i=0; i<money.length; i++) {
            for(int j=money[i]; j<n+1; j++){
                // money[i]가 주어진 예시로 치면 1,2,5
                // 기존 dp[j]는 첫 for문이 돌면서 각 화폐 단위를 활용해 n원을 거슬러 줄 방법의 수
                // 예를 들면, 첫 for문이 처음 돌 때는 1원만 가지고 j원을 거슬러 줄 방법이 저장, 
                //          두번째 돌 때는 1,2원만 가지고 j원을 거슬러 줄 방법이 저장되는 식
                // 아래 식은 현재까지의 j원을 거슬러 줄 방법의 수인 dp[j]에다가, 
                // money[i] 단위가 추가될 시 새로 생길 방법의 가짓수를 더한 형태. 
                // 그림 그려보면, 결국 dp[j-money[i]]에다가 money[i] 덩어리를 갖다붙이는 형태로 생각하면 된다.
                dp[j] = dp[j] + dp[j-money[i]];
            }   
        }
        
        return dp[n] % NUMBER;
    }
    
}