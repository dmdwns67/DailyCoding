import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][4];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if(Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])){
                if(Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])){
                    if(Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])){
                        // Korean, English, Math same -> Name asc
                        return s1[0].compareTo(s2[0]);
                    }

                    // Korean, English same -> Math desc
                    return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3])); 
                }
                
                // Korean same -> English asc
                return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));   
            }

            // Korean diff -> desc
            return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1])); 
        });

        for(int i=0; i<N; i++){
            System.out.println(arr[i][0]);
        }
    }
}