import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int x = -1, y = -1;
        for(int i=0; i<A.length(); i++){
            for(int j=0; j<B.length(); j++){
                if(A.charAt(i) == B.charAt(j)) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1 || y != -1) break;
        }

        Character[][] ans = new Character[B.length()][A.length()];
        for(Character[] arr : ans){
            Arrays.fill(arr, '.');
        }

        for(int i=0; i<A.length(); i++){
            ans[y][i] = A.charAt(i);
        }

        for(int j=0; j<B.length(); j++){
            ans[j][x] = B.charAt(j);
        }

        for(Character[] arr : ans){
            for(Character ch : arr) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}