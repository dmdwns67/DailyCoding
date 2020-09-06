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
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<trees.length; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long min = 1;
        long max = (long)Arrays.stream(trees).max().getAsInt();
        long height = 0;
        while(min <= max){
            height = (max + min) / 2;
            long wood = 0;
            for(int i=0; i<trees.length; i++){
                if(trees[i] > height){
                    wood += trees[i] - height;
                }
            }

            if(wood >= M){
                min = height + 1L;
            } else if(wood < M) {
                max = height - 1L;
            } 
        }

        System.out.println(max);

        br.close();
    }
}
