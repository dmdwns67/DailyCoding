import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int cnt0 = 0;
        int cnt1 = 0;

        if(S.charAt(0) == '1') cnt0++;
        else cnt1++;

        for(int i=0; i<S.length()-1; i++){
            if(S.charAt(i) != S.charAt(i+1)){
                if(S.charAt(i+1) == '1'){
                    // case1 : every number will turn to 0.
                    // if the next num is 1, then flip it.
                    cnt0++;
                } else {
                    // case2 : every number will turn to 1.
                    cnt1++;
                }
            }
        }

        System.out.println(Math.min(cnt0, cnt1));

        sc.close();
    }
}