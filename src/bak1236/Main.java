import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        int[] row = new int[N];
        int[] col = new int[M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                if(line.charAt(j) == 'X'){
                    arr[i][j] = 1;
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        int rowCnt = 0;
        for(int i=0; i<row.length; i++){
            if(row[i] == 0) rowCnt++; 
        }

        int colCnt = 0;
        for(int i=0; i<col.length; i++){
            if(col[i] == 0) colCnt++;
        }

        System.out.println(Math.max(rowCnt, colCnt));

        br.close();
    }
}