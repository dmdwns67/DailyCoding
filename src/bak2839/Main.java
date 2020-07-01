import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N%5 == 0) { // only 5kg bags
            System.out.println(N/5);
            return;
        } else { // mixed with 3kg and 5kg   
            for(int i  = N/5; i>0; i--){
                int temp = N - (5*i);
                if(temp%3 == 0) {
                    System.out.println(i + (temp/3));
                    return; 
                }
            }
        }

        if( N%3 == 0 ) { // only 3kg bags
            System.out.println(N/3);
        } else { // impossible case
            System.out.println(-1);
        }       

        sc.close();
    }
}