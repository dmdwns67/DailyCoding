import java.util.Scanner;

public class Main {
    static int minVal=Integer.MAX_VALUE, maxVal=Integer.MIN_VALUE, N=0;
    static int[] operater, number;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        number = new int[N];
        for(int i=0; i<N; i++){
            number[i] = sc.nextInt();
        }
        operater = new int[4]; // +, -, x, / 의 개수
        for(int i=0; i<operater.length; i++){
            operater[i] = sc.nextInt();
        }

        dfs(1, number[0]);

        System.out.println(maxVal);
        System.out.println(minVal);

        sc.close();
    }

    public static void dfs(int depth, int sum){
        if(depth == N){
            minVal = Math.min(minVal, sum);
            maxVal = Math.max(maxVal, sum);
        }

        for(int i=0; i<4; i++){
            if(operater[i] > 0){
                operater[i]--;
                switch(i){
                    case 0: // +
                        dfs(depth+1, sum + number[depth]);
                        break;
                    case 1: // -
                        dfs(depth+1, sum - number[depth]);
                        break;
                    case 2: // x
                        dfs(depth+1, sum * number[depth]);
                        break;
                    case 3: // /
                        dfs(depth+1, sum / number[depth]);
                        break;
                }
                operater[i]++;
            }
        }        
    }
}