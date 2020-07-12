import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<N; i++) {
            hs.add(sc.nextInt());
        }

        int M = sc.nextInt();
        for(int i=0; i<M; i++){
            if(hs.contains(sc.nextInt())){
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }

        sc.close();
    }
}