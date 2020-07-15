import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            N = Integer.parseInt(br.readLine());

            solution(0, 1, 1, 1, "1");

            System.out.println();
        }
        
        br.close();
    }

    public static void solution(int sum, int sign, int num, int cnt, String result) {
            if(cnt == N){
                sum = sum + (sign*num);

                if( sum == 0){
                    System.out.println(result);
                }
                return;
            }

            solution(sum, sign, num*10+(cnt+1), cnt+1, result + " " +Integer.toString(cnt+1));
            solution(sum+(sign*num), 1, cnt+1, cnt+1, result + "+" +Integer.toString(cnt+1));
            solution(sum+(sign*num), -1, cnt+1, cnt+1, result + "-" +Integer.toString(cnt+1));
    }
}