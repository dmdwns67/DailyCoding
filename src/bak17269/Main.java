import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String A = sc.next();
        String B = sc.next();

        int[] alpha = {3,2,1,2,4,3,1,3,1,1
                        ,3,1,3,2,1,2,2,2,1,2
                        ,1,1,1,2,2,1};

        String AB = "";
        int minLen = Math.min(A.length(), B.length());
        for(int i=0; i<minLen;i ++){
            AB += Character.toString(A.charAt(i)) + Character.toString(B.charAt(i));
            //System.out.println(i+": "+AB);
        }

        AB += A.substring(minLen) + B.substring(minLen);
        //System.out.println("result: "+AB);

        int[] arr = new int[AB.length()];
        for(int i=0; i<AB.length(); i++){
            arr[i] = (int)(alpha[AB.charAt(i) - 'A']);
        }

        for(int i=0; i<AB.length()-2; i++){
            for(int j=0; j<AB.length()-1-i; j++){
                arr[j] += arr[j+1];
                arr[j] %= 10;
            }
        }

        int answer = arr[0]*10 + arr[1];

        System.out.println( answer + "%");

        sc.close();
    }
}