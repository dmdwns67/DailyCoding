import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(0,0,0,0));

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            blocks.add(new Block(area, height, weight, i));
        }

        // weight 기준 오름차순 정렬
        Collections.sort(blocks, (b1, b2) -> {
            return Integer.compare(b1.weight, b2.weight);
        });

        /*
        System.out.println("==================================");
        for(Block b : blocks){
            System.out.println(b.idx + " " +b.area+" "+b.height+" "+b.weight);
        }
        System.out.println("==================================");
        */

        int[] dp = new int[N+1];
        Arrays.fill(dp, 0);

        for(int i=1; i<N+1; i++){
            for(int j=0; j<i; j++){
                if(blocks.get(i).area > blocks.get(j).area){
                    dp[i] = Math.max(dp[i], dp[j]+blocks.get(i).height);
                }
            }
        }

        /*
        System.out.println("==================================");
        for(int i : dp){
            System.out.print(i +" ");
        }
        System.out.println();
        System.out.println("==================================");
        */

        int maxVal = Arrays.stream(dp).max().getAsInt();
        int idx = N;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(idx != 0){
            if(maxVal == dp[idx]){
                result.add(blocks.get(idx).idx);
                maxVal -= blocks.get(idx).height;
            }
            idx--;
        }

        Collections.reverse(result);
        
        System.out.println(result.size());
        for(int i : result){
            System.out.println(i);
        }

        br.close();
    }
}

class Block {
    int area;
    int height;
    int weight;
    int idx;

    public Block(int area, int height, int weight, int idx){
        this.area = area;
        this.height = height;
        this.weight = weight;
        this.idx = idx;
    }
}