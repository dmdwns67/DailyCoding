import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        combination(0, "");

        br.close();
    }

    public static void combination(int idx, String ret){
        if(ret.length() == L) {
            if(isPossible(ret)) {
                System.out.println(ret);
            }
            return;
        }
        if(idx >= C) return;

        combination(idx+1, ret + arr[idx]);
        combination(idx+1, ret);
    }

    public static boolean isPossible(String str){
        int v = 0;
        int c = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                v++;
            } else {
                c++;
            }
        }
        return v>=1 && c >=2;
    }
}