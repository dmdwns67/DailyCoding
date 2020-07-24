import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] conn;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        conn = new ArrayList[N+1];

        for(int i=0; i<conn.length; i++){
            conn[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<M+1; i++){
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            conn[c1].add(c2);
            conn[c2].add(c1);
        }

        visited = new boolean[N+1];
        Arrays.fill(visited, Boolean.FALSE);

        dfs(1);

        System.out.println(cnt-1);

        sc.close();
    }

    public static void dfs(int computer){
        cnt++;
        visited[computer] = true;
        for(int c : conn[computer]){
            if(!visited[c]){
                dfs(c);
            }
        }
    }
}