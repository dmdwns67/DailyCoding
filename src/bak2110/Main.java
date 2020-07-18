import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> houses = new ArrayList<Integer>();
        //int[] houses = new int[N];

        for(int i=0; i<N; i++){
            houses.add(Integer.parseInt(br.readLine()));
            //houses[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(houses);
        //Arrays.sort(houses);

        // Binary Search
        int result = 0;
        int minGap = houses.get(1) - houses.get(0);
        int maxGap = houses.get(houses.size()-1) - houses.get(0);
        //int minGap = houses[1] - houses[0];
        //int maxGap = houses[N-1] - houses[0];
        while(minGap <= maxGap){
            int midGap = (minGap + maxGap) / 2;
            int value = houses.get(0);
            //int value = houses[0];
            int cnt = 1;
            for(int i=1; i<N; i++){
                if(houses.get(i) >= value + midGap){
                //if(houses[i] >= value + midGap){
                    value = houses.get(i);
                    //value = houses[i];
                    cnt++;
                }
            }
            if(cnt >= C){
                minGap = midGap + 1;
                result = midGap;
            } else {
                maxGap = midGap - 1;
            }
        }

        System.out.println(result);

        br.close();
    }
}