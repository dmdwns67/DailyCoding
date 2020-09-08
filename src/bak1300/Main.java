import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int left = 1;
        int right = k; // k번째 수는 절대 k보다 클 수가 없다.
        int answer = 0;
        while(left <= right) {
            int mid = (left+right) / 2;
            int sum = 0;
            for(int i=1; i<=N; i++) {
                sum += Math.min(mid/i, N); // i=1 일때는 최대 N이므로 Math.min을 쓴거다.
            }

            if(sum >= k) {
                right = mid -1;
                answer = mid;
            } else {
                left = mid +1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}
