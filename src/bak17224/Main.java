import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 문제의 개수
        int L = sc.nextInt(); // 현정이의 역량
        int K = sc.nextInt(); // 현정이가 풀 수 있는 최대 문제 수

        int hardCnt = 0;
        int easyCnt = 0;
        for(int i=0; i<N; i++){
            int easy = sc.nextInt();
            int hard = sc.nextInt();

            if(hard <= L){
                hardCnt++;
            } else if(easy <= L){
                easyCnt++;
            }
        }

        int score = 0;
        if(hardCnt < K){
            score = hardCnt * 140 + Math.min((K-hardCnt),easyCnt) * 100;
        } else {
            score = K * 140;
        }

        System.out.println(score);

        sc.close();
    }
}