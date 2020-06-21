import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        // idx 0: A, 1: B, 2: C
        int[] bottle = new int[3];

        int[] from = {0,0,1,1,2,2};
        int[] to = {1,2,0,2,0,1};
        boolean[][] visited = new boolean[201][201];
        boolean[] remainC = new boolean[201];

        // GET Input value
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            bottle[i] = Integer.parseInt(st.nextToken());
        }

        // Make a Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // init state, A and B is empty
        q.add(new Pair(0,0));
        visited[0][0] = true;
        remainC[bottle[2]] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int A = p.a;
            int B = p.b;
            int C = bottle[2] - A - B;
            
            // possible 6 ways to move water
            for(int j=0; j<6; j++){
                int[] next = {A, B, C};
                next[to[j]] += next[from[j]];

                // 넣으려는 물이 물통보다 많은 경우, 물을 다 붓지 못한다.
                if(next[to[j]] > bottle[to[j]]){
                    next[from[j]] = next[to[j]] - bottle[to[j]];
                    next[to[j]] = bottle[to[j]];
                } else { // 물은 다 부은 경우
                    next[from[j]] = 0;
                }

                // 기체크 여부 확인
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
                    // A가 빈 경우, C의 잔여량은 저장
                    if(next[0] == 0) remainC[next[2]] = true;
                }
            }
        }

        for(int i=0; i<bottle[2]+1; i++){
            if(remainC[i]) System.out.print(i + " ");
        }
    }
}

class Pair{
    int a;
    int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}