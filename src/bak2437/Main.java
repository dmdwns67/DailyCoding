import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] w = new int[N];
        for(int i=0; i<N; i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(w);

        int answer = 0;
        for(int weight : w){
            if(weight <= answer+1){
                answer += weight;
            } else {
                break;
            }
        }

        System.out.println(answer+1);

        br.close();
    }
}