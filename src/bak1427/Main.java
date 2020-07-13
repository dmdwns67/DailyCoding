import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        for(int i=9; i>-1; i--){
            for(int j=0; j<input.length(); j++){
                if((int)input.charAt(j)-48 == i){
                    System.out.print(i);
                }
            }
        }
        
        
        br.close();
    }
}