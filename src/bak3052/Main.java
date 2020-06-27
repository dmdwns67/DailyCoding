import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())%42;

            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        System.out.println(map.size());
    }
}