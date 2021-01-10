import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i]=i;
        }

        dfs(1,0, "");
    }

    public static void dfs(int pos, int depth, String str) {
        if(depth == M) {
            System.out.println(str);
            return;
        }

        for(int i=pos; i<=N; i++) {
            dfs(i+1, depth+1, str + Integer.toString(arr[i]) + " ");
        }
    }
}