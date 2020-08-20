import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Integer N = sc.nextInt();
        Integer M = sc.nextInt();

        Boolean[][] adj = new Boolean[N+1][N+1];
        for(int i=0; i<adj.length; i++){
            Arrays.fill(adj[i], Boolean.FALSE);
        }

        for(int i=1; i<=M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = true;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    if(i==j || i==k || j==k) continue;

                    if(adj[j][i] && adj[i][k]){
                        adj[j][k] = true;
                    }
                }
            }
        }


        int answer = 0;
        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=1;j <=N; j++){
                if(i==j) continue;

                if(adj[i][j] || adj[j][i]) cnt++;
            }

            if(cnt == N-1){
                answer++;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}