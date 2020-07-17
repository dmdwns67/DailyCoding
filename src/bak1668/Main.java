import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] shelf = new Integer[N];

        for(int i=0; i<N; i++){
            shelf[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int top = 0;
        for(int i=0; i<shelf.length; i++){
            if(shelf[i] > top){
                cnt++;
                top = shelf[i];
            }
        }

        System.out.println(cnt);
        
        Collections.reverse(Arrays.asList(shelf));

        cnt = 0;
        top = 0;
        for(int i=0; i<shelf.length; i++){
            if(shelf[i] > top){
                cnt++;
                top = shelf[i];
            }
        }

        System.out.println(cnt);

        br.close();
    }
}