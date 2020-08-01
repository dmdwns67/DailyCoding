import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String S = sc.next();

        int score = 0;
        int bonus = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'O' || S.charAt(i) == 'o'){
                score += i+1+bonus;
                bonus++;
            } else {
                bonus = 0;
            }
        }

        System.out.println(score);

        sc.close();
    }
}