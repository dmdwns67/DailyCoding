import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int sec = 0;
        int k = 1;
        while (N!=0){
            if(k > N){
                k = 1;
            }
            N = N - k;
            k++;
            sec++;
        }

        System.out.println(sec);

        sc.close();
    }
}