import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }
        
        Arrays.sort(arr, (o1, o2)->{
            return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        });

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i][0] +" "+arr[i][1]);
        }
        
        br.close();
    }
}