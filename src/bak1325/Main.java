import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] relations;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        relations = new ArrayList[N+1];
        for(int i=0;i<relations.length; i++){
            relations[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            relations[c2].add(c1);
        }

        int maxVal = -1;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=1; i<N+1; i++){
            visited = new boolean[N+1];
            Arrays.fill(visited, Boolean.FALSE);
 
            int count = bfs(i);

            if(count > maxVal){
                answer = new ArrayList<Integer>();
                answer.add(i);
                maxVal = count;
            } else if (count == maxVal){
                answer.add(i);
            }
        }

        for(int num : answer){
            System.out.print(num + " ");
        }

        br.close();
    }

    public static int bfs(int c){
        int count = 1;

        q = new LinkedList<Integer>();
        q.add(c);
        visited[c] = true;
        while(!q.isEmpty()){
            int com = q.poll();
            for(int computer : relations[com]){
                if(!visited[computer]){
                    q.add(computer);
                    visited[computer] = true;
                    count++;
                }
            }
        }

        return count;
    }
}