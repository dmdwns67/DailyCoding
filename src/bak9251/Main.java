import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] arr = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(arr[i], 0);
        }

        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[i].length; j++){
                if(s1.charAt(i-1) != s2.charAt(j-1)){
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                } else {
                    // s1.charAt(i-1) == s2.charAt(j-1)
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
            }
        }
        /*
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        */

        System.out.println(arr[s1.length()][s2.length()]);

        br.close();
    }
}