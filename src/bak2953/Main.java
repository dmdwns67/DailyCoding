import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int arr[][] = new int[6][5];
        int sum = 0;
        int idx = 0;
        for(int i=1; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][0] += arr[i][j];
            }

            if(arr[i][0] > sum) {
                sum = arr[i][0];
                idx = i;
            }

        }
        
        System.out.println(idx + " " +sum);

    }
}