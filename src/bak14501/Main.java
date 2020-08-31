import java.util.Scanner;

public class Main {
    static int N;
    static int[] T, P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int max = dfs(0);

        System.out.println(max);

        sc.close();
    }

    public static int dfs(int day){
        // 마지막 날 이후에는 상담 못함
        if(day >= N){
            return 0;
        }

        int money = 0;
        // 1. 상담을 진행할 경우
        if(day + T[day] <= N){
            money = Math.max(money, dfs(day+T[day]) + P[day]);
        }

        // 2. 상담을 진행하지 않은 경우, 하루 추가
        if(day + 1 < N){
            money = Math.max(money, dfs(day+1));
        }

        return money;
    }
}