import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] row;
    static int n, result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        row = new int[n];
        Arrays.fill(row, 0);

        result = 0;
        dfs(0);

        System.out.println(result);

        sc.close();
    }

    // x번째 행에 대하여 처리
    public static void dfs(int x){
        if(x == n){
            result++;
        } else {
            // x번째 행의 각 열에 퀸을 둔다고 가정
            for(int i=0; i<n; i++){
                row[x] = i;
                // 해당 위치에 Queen을 두어도 괜찮은 경우
                if(check(x)){
                    dfs(x+1);
                }
            }
        }
    }

    // x번째 행에 높은 Queen에 대해서 검증
    public static boolean check(int x){
        // 이전 행에서 놓았던 모든 Queen 들을 확인
        for(int i=0; i<x; i++){
            // 위쪽 혹은 대각선을 확인
            if(row[x] == row[i]){
                return false;
            } 
            if((int)Math.abs(row[x]-row[i]) == x-i){
                return false;
            }
        }
        return true;
    }
}