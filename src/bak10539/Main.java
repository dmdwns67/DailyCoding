import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0; i<n; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(b.get(0));

        for(int i=1; i<n; i++){
            a.add( (b.get(i)*(i+1)) - (a.stream().mapToInt(num -> num.intValue()).sum()) );
        }

        for(int i : a){
            System.out.print(i + " ");
        }

        br.close();
    }
}