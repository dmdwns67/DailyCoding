import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int rlt = 0, keep = 0, cur = 0, bef = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // init current state
        cur = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            bef = cur;
            cur = Integer.parseInt(st.nextToken());
            if( cur - bef > 0 ) { // up
                keep += (cur - bef);
            } else { // down
                rlt = Math.max(rlt, keep);
                keep = 0;
            }
        }
        
        rlt = Math.max(rlt, keep);
        System.out.println(rlt);
    }
}