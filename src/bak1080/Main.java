import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A, B;
    static int answer, M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        
        B = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                B[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        answer = 0;
        // 3 x 3 을 뒤집기 위한 loop
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                if(A[i][j] != B[i][j]){
                    flip(i,j,A);
                    answer++;
                }
            }
        }

        if(check()){
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    public static void flip(int x, int y, int[][] A) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(A[x+i][y+j] == 1) {
                    A[x+i][y+j] = 0;
                } else {
                    A[x+i][y+j] = 1;
                }
            }
        }
    }

    public static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}