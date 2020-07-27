import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int pay = sc.nextInt();
        int change = 1000 - pay;
        int cnt = 0;

        for(int coin : new int[]{500, 100, 50, 10, 5, 1}){
            cnt += change / coin;
            change %= coin;
        }

        /*
        int[] coins = {500, 100, 50, 10, 5, 1};

        while(change != 0){
            for(int i=0; i<coins.length; i++){
                while(coins[i] <= change){
                    change = change - coins[i];
                    cnt++;
                }
            }
        }
        */

        System.out.println(cnt);


        sc.close();
    }
}