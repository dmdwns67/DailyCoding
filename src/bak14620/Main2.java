import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        answer = Integer.MAX_VALUE;

        dfs(0,0);

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int level, int sum){
        if(level == 3){
            answer = Math.min(answer, sum);
            return;
        }
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                int nextSum = sum;
                boolean isVisited = false;
                for(int d=0; d<5; d++){
                    if(!visited[i+dx[d]][j+dy[d]]){
                        nextSum += map[i+dx[d]][j+dy[d]];
                    } else {
                        isVisited = true;
                        break;
                    }
                }
                
                if(!isVisited){
                    for(int d=0; d<5; d++){
                        visited[i+dx[d]][j+dy[d]] = true;
                    }
                    dfs(level+1, nextSum);
                    for(int d=0; d<5; d++){
                        visited[i+dx[d]][j+dy[d]] = false;
                    }   
                }
            }
        }
    }
}