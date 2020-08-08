import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int n,m,k;
    static int[][] rcs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rcs = new int[k][3];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                rcs[i][j] = Integer.parseInt(st.nextToken());
            }
        } 

        dfs(A, new int[k]);

        System.out.println(answer);

        br.close();
    }

    public static int getMinValue(int[][] arr){
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            min = Math.min(min, Arrays.stream(arr[i]).sum());
        }
        return min;
    }

    public static int[][] rotate(int[][] arr, int[] rcs) {
        int r = rcs[0]-1;
        int c = rcs[1]-1;
        int s = rcs[2];

        int[] dx = {1,0,-1,0}; // south, west, north, east
        int[] dy = {0,-1,0,1};

        // copy arr to newArr
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0; i<newArr.length; i++){
            for(int j=0; j<newArr[i].length; j++){
                newArr[i][j] = arr[i][j];
            }
        }

        // rotate
        for(int i=1; i<s+1; i++){
            int x = r-i;
            int y = c+i; // 오른쪽 대각선으로 기준점 (x,y) 이동
            for(int dir=0; dir<4; dir++){
                // 남서북동 순서로 i*2번만큼 이동시킨다.
                for(int cnt=0; cnt<i*2; cnt++){
                    int nextx = x +dx[dir];
                    int nexty = y +dy[dir];
                    newArr[nextx][nexty] = arr[x][y];

                    x = nextx;
                    y = nexty;
                }
            }
        }
        
        return newArr;
    }

    public static void dfs(int[][] arr, int[] chk){
        if(Arrays.stream(chk).sum() == k)  {
            answer = Math.min(answer, getMinValue(arr));
            return;
        }     
        for(int i=0; i<k; i++){
            if(chk[i] == 1) continue;

            int[][] newArr = rotate(arr, rcs[i]);
            chk[i] = 1;
            dfs(newArr, chk);
            chk[i] = 0;
        }
    }
}