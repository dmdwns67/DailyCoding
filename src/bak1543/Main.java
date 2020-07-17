import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String docu = br.readLine();
        String word = br.readLine();

        int idx = 0;
        int result = 0;
        while (docu.length() - idx >= word.length()) {
            if (docu.substring(idx, idx + word.length()).equals(word)) {
                idx += word.length();
                result++;
            } else {
                idx++;
            }
        }

        System.out.println(result);

        br.close();
    }
}