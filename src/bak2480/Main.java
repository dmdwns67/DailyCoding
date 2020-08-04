import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<3; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        HashSet<Integer> set = new HashSet<>(arr);

        if(set.size() == 1){
            System.out.println(10000 + 1000 * arr.get(0));
        } else if (set.size() == 2) {
            System.out.println(1000 + 100 * arr.get(1));
        } else {
            System.out.println(100 * arr.get(2));
        }

        sc.close();
    }
}