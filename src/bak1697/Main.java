import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] cnt;
    static boolean[] visited;
    static Queue<Integer> q;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        cnt = new int[100001];
        Arrays.fill(cnt, 0);
        visited = new boolean[100001];
        Arrays.fill(visited, Boolean.FALSE);

        q = new LinkedList<Integer>();
        int answer = bfs(N, K);

        System.out.println(answer);

        sc.close();
    }

    public static int bfs(int n, int k){
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int pos = q.poll();
            if (pos == k) {
                return cnt[pos];
            }
            int[] rules = {pos-1, pos+1, pos*2};
            for(int nextPos : rules){
                if(0 <= nextPos && nextPos < 100001 && !visited[nextPos]){
                    cnt[nextPos] = cnt[pos] + 1;
                    visited[nextPos] = true;
                    q.add(nextPos);
                }
            }
        }

        return -1;
    }
}