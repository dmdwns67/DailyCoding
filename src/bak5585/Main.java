import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] coins = {500, 100, 50, 10, 5, 1};

        int pay = sc.nextInt();
        int change = 1000 - pay;

        int cnt = 0;
        while(change != 0){
            for(int i=0; i<coins.length; i++){
                while(coins[i] <= change){
                    //System.out.println(coins[i]+"엔 차감");
                    change = change - coins[i];
                    cnt++;
                    //System.out.println("현재 change: " + change +", cnt: "+cnt);
                }
            }
        }

        System.out.println(cnt);


        sc.close();
    }
}