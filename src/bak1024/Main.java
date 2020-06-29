import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        List<Integer> ans = new ArrayList<>();

        ans = Main.search(N, L);
        
        for(int num : ans){
            System.out.print(num + " ");
        }

        br.close();
    }

    public static List search(int N, int L){
        List<Integer> ans = new ArrayList<>();

        for(int i = L; i<101; i++){
            // Sum = n( 2a + (n-1)d ) / 2
            // d=1, Sum=N, n=i
            // a = (2N -i(i-1)) / 2i
            if((2*N >= i*(i-1)) && (2*N -i*(i-1))%(2*i) == 0) {
                int first = ( 2*N - i*(i-1) ) / (2*i);
                for(int add = 0; add < i; add++){
                    ans.add(first+add);
                }
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }
}