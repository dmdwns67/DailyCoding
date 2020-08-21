import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];

        int cnt = 0;
        if(N % 2 == 0) { // N이 홀수이면 타일을 채울 수 없다.
            dp[0] = 1;  
            dp[2] = 3;
            // dp[4] = 3*dp[2] + 2*dp[0]
            // dp[6] = 3*dp[4] + 2*dp[2] + 2*dp[0]
            // 1. 2칸 늘어날때마다 그 2칸에서 가짓수 3개가 추가된다.
            // 2. 마지막 칸에 "이전" 특수 케이스(바닥에 한줄 or 천장에 한줄)들을 넣는 경우를 고려한다.
            //      예를 들어, dp[6] 계산 시에 2*dp[2]는 뒤에 길이 4짜리 특수케이스를 넣었을 때다.
            // 3. 전체 칸 특수케이스 2개(2*dp[0]) c추가한다.
            for(int i=4; i<=N; i+=2){
                for(int j=2; j<=i; j+=2){
                    if(j==2){
                        dp[i] += 3*dp[i-j];
                    } else {
                        dp[i] += 2*dp[i-j];
                    }
                }
            }
            cnt = dp[N];
        }

        System.out.println(cnt);

        sc.close();
    }
}