import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int a = 0, b = 1;

        while(N>0){
            int tmp = a;
            a = b;
            b = b + tmp;
            N--;
        }

        System.out.println(a);
        
        br.close();
    }
}