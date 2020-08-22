import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new int[N+1][N+1]; // [이모티콘 개수][클립보드에 있는 이모티콘 개수]
        for(int i=0; i<N+1; i++) Arrays.fill(visited[i], -1); // -1 : 방문하지 않음

        bfs();

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<N+1; i++){
            if(visited[N][i] != -1) {
                ans = Math.min(ans, visited[N][i]);
            }
        }

        System.out.println(ans);

        br.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1); // 영선이가 이미 1개 입력했음
        q.add(0); // 클립보드는 비었음
        visited[1][0] = 0;

        while(!q.isEmpty()){
            int s = q.poll();
            int c = q.poll();
            if(visited[s][s] == -1){ // case1 : 화면 이모티콘 모두 클립보드 복사
                visited[s][s] = visited[s][c] + 1;
                q.add(s);
                q.add(s);
            }
            if(s+c <= N && visited[s+c][c] == -1) { // case2 : 모든 클립보드 이모티콘 화면 붙여넣기
                visited[s+c][c] = visited[s][c] + 1;
                q.add(s+c);
                q.add(c);
            }
            if(s-1 >= 0 && visited[s-1][c] == -1){ // case3 : 화면 이모티콘 중 1개 삭제
                visited[s-1][c] = visited[s][c] + 1;
                q.add(s-1);
                q.add(c);
            }
        }
    }
}