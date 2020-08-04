import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[4];
        for(int i=0; i<4; i++){
            // S: 가위(0) , P: 보(1) , R: 바위(2)
            arr[i] = "SPR".indexOf(st.nextToken(), 0);
        }

        if(arr[0]==arr[1] && ( (arr[0]+2)%3 == arr[2] || (arr[0]+2)%3 == arr[3]) ){
            System.out.println("TK");
        } else if(arr[2]==arr[3] && ( (arr[2]+2)%3 == arr[0] || (arr[2]+2)%3 == arr[1]) ){
            System.out.println("MS");
        } else {
            System.out.println("?");
        }

        br.close();
    }
}