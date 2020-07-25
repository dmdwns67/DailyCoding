import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// DFS는 시간초과
public class Main2 {
    static boolean[] visited;
    static ArrayList<Integer>[] relations;
    static int cnt;
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
            cnt = 0;
            visited = new boolean[N+1];
            Arrays.fill(visited, Boolean.FALSE);
            
            dfs(i);

            if(cnt > maxVal){
                answer = new ArrayList<Integer>();
                answer.add(i);
                maxVal = cnt;
            } else if (cnt == maxVal){
                answer.add(i);
            }
        }

        for(int num : answer){
            System.out.print(num + " ");
        }

        br.close();
    }

    public static void dfs(int c){
        cnt++;
        visited[c] = true;
        for(int computer : relations[c]){
            if(!visited[computer]){
                dfs(computer);
            }
        }
    }
}