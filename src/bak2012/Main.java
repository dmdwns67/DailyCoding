import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> stu = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            stu.add(sc.nextInt());
        }

        Collections.sort(stu);

        long answer = 0;
        for(int i=1; i<n+1; i++){
            answer = answer + Math.abs(i-stu.get(i-1));
        }

        System.out.println(answer);

        sc.close();
    }
}