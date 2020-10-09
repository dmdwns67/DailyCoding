import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H,addLadder;
    static int[][] lines;
    static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        lines = new int[H+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[a][b] = 1;
        }

        // 추가로 놓을 수 있는 사다리는 0~3.
        for(int i=0; i<=3; i++) {
            addLadder = i;
            putLadder(1,1,0);
            if(found) break;
        }

        System.out.println(found? addLadder : -1);

        br.close();
    }

    public static void putLadder(int x, int y, int ladderCnt) {
        if(found) return;

        if(addLadder == ladderCnt) {
            if(descendingLadder()) {
                found = true;
            }
            return;
        }

        for(int i=x; i<=H; i++){
            for(int j=1; j<N; j++) {
                if(lines[i][j]==1 || lines[i][j-1]==1 || lines[i][j+1]==1) continue;
                lines[i][j] = 1;
                putLadder(i, j, ladderCnt+1);
                lines[i][j] = 0;
            }
        }
    }

    public static boolean descendingLadder() {
        for(int actor=1; actor<=N; actor++) {
            int verti = 1; // 세로줄 레벨
            int hori = actor;
            while(verti <= H) {
                if(lines[verti][hori] == 1) {
                    hori++;
                } else if(lines[verti][hori-1] == 1) {
                    hori--;
                }
                verti++;
            }
            if(actor != hori) {
                return false;
            }
        }
        return true;
    }
}
