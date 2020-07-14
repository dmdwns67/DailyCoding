import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = 0;

        solution(Math.pow(2,N), 0, 0);

        br.close();
    }

    public static void solution(double n, double x, double y){
        if(n == 2){
            if(x == R && y == C){
                System.out.println(cnt);
                return;
            }
            cnt++;
            if(x == R && y+1 == C){
                System.out.println(cnt);
                return;
            }
            cnt++;
            if(x+1 == R && y == C){
                System.out.println(cnt);
                return;
            }
            cnt++;
            if(x+1 == R && y+1 == C){
                System.out.println(cnt);
                return;
            }
            cnt++;
        } else {
            solution(n/2, x, y);
            solution(n/2, x, y+n/2);
            solution(n/2, x+n/2, y);
            solution(n/2, x+n/2, y+n/2);
        }
    }
}