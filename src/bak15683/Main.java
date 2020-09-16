import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,minVal,cctvNum;
    static int[][] map, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int x=0,y=0;
        boolean findStart = false;
        map = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 6) {
                    visited[i][j] = -1;
                }
                if(map[i][j] != 0 && map[i][j] != 6) {
                    cctvNum++;
                    if(!findStart) {
                        x = i;
                        y = j;
                        findStart = true;
                    }
                }
            }
        }

        minVal = Integer.MAX_VALUE;
        countNonCCTVArea(x+y,1);

        System.out.println(minVal);

        br.close();
    }

    public static void countNonCCTVArea(int idx, int cnt){
        if(cnt > cctvNum) {
            minVal = Math.min(minVal, countArea());
            return;
        }

        for(int index=idx; index<N*M; index++){
            int i = index / M;
            int j = index % M;
                if(map[i][j] != 0 && map[i][j] != 6) {
                    switch(map[i][j]) {
                        case 1:
                        case 3:
                        case 4:
                            for(int k=0; k<4; k++){
                                updateCCTVArea(i, j, map[i][j], k, 1);
                                countNonCCTVArea(index+1, cnt+1);
                                updateCCTVArea(i, j, map[i][j], k, 0);
                            }
                            break;
                        case 2:
                            for(int k=0; k<4; k+=2){
                                updateCCTVArea(i, j, 2, k, 1);
                                countNonCCTVArea(index+1, cnt+1);
                                updateCCTVArea(i, j, 2, k, 0);
                            }
                            break;
                        case 5:
                            updateCCTVArea(i, j, 5, -1, 1);
                            countNonCCTVArea(index+1, cnt+1);
                            updateCCTVArea(i, j, 5, -1, 0);
                            break;
                    }
                }
            
        }
    }

    public static void updateCCTVArea(int x, int y, int cctv, int idx, int flag) {
        int[] dx = {-1,1,0,0}; // 상하좌우
        int[] dy = {0,0,-1,1};
        int nx=0, ny=0;
        switch(cctv) {
            case 1:
                nx = x +dx[idx];
                ny = y +dy[idx];
                while(true) {
                    if(nx>=0 && ny>=0 && nx<N && ny<M) {
                        if(map[nx][ny] == 6) break;
                        if(flag == 1) {
                            visited[nx][ny]++;}
                        else {
                            visited[nx][ny]--;}
                        nx = nx + dx[idx];
                        ny = ny + dy[idx];
                    } else { break; }
                }
                break;
            case 2: // 0,1 / 2,3
                for(int i=0; i<2; i++) {
                    nx = x +dx[idx+i];
                    ny = y +dy[idx+i];
                    while(true) {
                        if(nx>=0 && ny>=0 && nx<N && ny<M) {
                            if(map[nx][ny] == 6) break;
                            if(flag == 1) {visited[nx][ny]++;}
                            else {visited[nx][ny]--;}
                            nx = nx + dx[idx+i];
                            ny = ny + dy[idx+i];
                        } else { break; }
                    }
                }
                break;
            case 3:
                // idx 0~3
                // 0123 상하좌우
                // 03 12 20 31
                for(int i=0; i<2; i++) {
                    nx = x +dx[idx];
                    ny = y +dy[idx];
                    while(true) {
                        if(nx>=0 && ny>=0 && nx<N && ny<M) {
                            if(map[nx][ny] == 6) break;
                            if(flag == 1) {visited[nx][ny]++;}
                            else {visited[nx][ny]--;}
                            nx = nx + dx[idx];
                            ny = ny + dy[idx];
                        } else { break; }
                    }

                    if(idx==0) idx = 3;
                    if(idx==1) idx = 2;
                    if(idx==2) idx = 0;
                    if(idx==3) idx = 1;
                }   
                break;
            case 4:
                // idx 0~3
                // 0123 상하좌우
                // 023 123 201 301
                for(int i=1; i<4; i++) {
                    nx = x +dx[(idx+i)%4];
                    ny = y +dy[(idx+i)%4];
                    while(true) {
                        if(nx>=0 && ny>=0 && nx<N && ny<M) {
                            if(map[nx][ny] == 6) break;
                            if(flag == 1) {
                                visited[nx][ny]++;}
                            else {
                                visited[nx][ny]--;}
                            nx = nx + dx[(idx+i)%4];
                            ny = ny + dy[(idx+i)%4];
                        } else { break; }
                    }
                }
                break;
            case 5:
                for(int i=0; i<4; i++) {
                    nx = x +dx[i];
                    ny = y +dy[i];
                    while(true) {
                        if(nx>=0 && ny>=0 && nx<N && ny<M) {
                            if(map[nx][ny] == 6) break;
                            if(flag == 1) {
                                visited[nx][ny]++;}
                            else {
                                visited[nx][ny]--;}
                            nx = nx + dx[i];
                            ny = ny + dy[i];
                        } else { break; }
                    }
                }      
                break;
        }   
    }

    public static int countArea(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] == 0 && map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
