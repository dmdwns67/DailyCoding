import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];

        br.readLine();
        //System.out.println("==============START============");
        for(int i=0; i<M; i++){
            int row = 5*i+1; // M=2 -> row: 1, 6
            //System.out.println("M:"+Integer.toString(i));

            for(int j=0; j<5; j++){
                String line = br.readLine();
                //System.out.println("READ LINE #"+Integer.toString(j));
                for(int k=0; k<N; k++){
                    int col = 5*k+1; // N=3 -> col: 1, 6, 11
                    if(line.charAt(col) == '*'){
                        arr[i][k]++;
                        //System.out.println("add 1 to (M,N) = ("+Integer.toString(i)+","+Integer.toString(k)+")" );
                    }
                } 

            }
        }

        Map<Integer, Integer> ans = new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
        }};

        for(int i=0; i<M;i++){
            for(int j=0; j<N; j++){
                if(ans.containsKey(arr[i][j])){
                    ans.put(arr[i][j], ans.get(arr[i][j])+1);
                }
            }
        }

        Iterator<Integer> keys = ans.keySet().iterator();
        while(keys.hasNext()){
            System.out.print(ans.get(keys.next()) + " ");
        }

        /*
        // desc
        Map<Integer, Integer> reverse = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        reverse.putAll(ans);

        Iterator<Integer> itr = reverse.keySet().iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        */

        br.close();
    }
}