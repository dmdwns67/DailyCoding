import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] burgers = new int[3];
        int[] drinks = new int[2];

        int minBurger = 2001;
        for(int i =0; i<3; i++){
            burgers[i] = sc.nextInt();
            minBurger = Math.min(burgers[i], minBurger);
        }

        int minDrink = 2001;
        for(int  i=0; i<2; i++){
            drinks[i] = sc.nextInt();
            minDrink = Math.min(drinks[i], minDrink);
        }

        System.out.println(minBurger + minDrink - 50);

        sc.close();
    }
}