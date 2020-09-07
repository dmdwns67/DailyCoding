import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] lines = new int[K];
        for(int i=0; i<K; i++){
            lines[i] = sc.nextInt();
        }

        long right = (long)Arrays.stream(lines).max().getAsInt();
        long left = 1;
        while(left <= right){ // 등호가 있어야 left, right가 같은 경우도 체크하고 나오지.
            long mid = (right + left) / 2;
            int cnt = 0;
            for(int i=0; i<lines.length; i++){
                cnt += lines[i] / mid;
            }

            if(cnt >= N){
                left = mid + 1;
            } else if(cnt < N){
                right = mid - 1;
            }
        }

        System.out.println(right);

        sc.close();
    }
}
