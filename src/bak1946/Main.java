import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int[] employees = new int[N+1];
            for(int i=1; i<N+1; i++){
                employees[sc.nextInt()] = sc.nextInt();
            }

            int cnt = 1;
            int priorEmployee = employees[1];
            for(int i=2; i<N+1; i++){
                if(employees[i] < priorEmployee){
                    priorEmployee = employees[i];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}