import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] C = new int[3];
        int[] M = new int[3];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            C[i] = sc.nextInt();
            M[i] = sc.nextInt();
        }

        for(int i=0; i<100; i++){
            int curr = i % 3;
            int next = (curr+1) % 3;

            if(M[curr]+M[next] > C[next]){
                M[curr] -= (C[next]-M[next]);
                M[next] = C[next];
            } else {
                M[next] += M[curr];
                M[curr] = 0;
            }
        }

        for(int i : M){
            System.out.println(i);
        }

        sc.close();
    }
}