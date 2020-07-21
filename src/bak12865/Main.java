import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][K+1];
        for(int i=0; i<N+1; i++){
            Arrays.fill(arr[i], 0);
        }

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j=1; j<K+1; j++){
                if(j < W){
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-W] + V);
                }
            }
        }

        System.out.println(arr[N][K]);

        br.close();
    }
}