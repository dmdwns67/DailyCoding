import java.util.Scanner;

public class Main {
    static int N, L, answer;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        answer = 0;
        checkHori();
        visited = new boolean[N][N];
        checkVert();

        System.out.println(answer);

        sc.close();
    }

    public static void checkHori() {
        for(int i=0; i<N; i++){
            int sameCnt = 1;
            boolean isPossible = true;
            for(int j=0; j<N-1; j++){
                if(map[i][j] == map[i][j+1]) {
                    sameCnt++;
                    continue;
                }

                if(map[i][j] > map[i][j+1]) {
                    // 내리막길(진행방향 체크)
                    // 차이가 1인지 확인
                    if(map[i][j] - map[i][j+1] != 1){
                        isPossible = false;
                        break;
                    }
                    
                    // 진행 방향 체크
                    sameCnt = 0;
                    for(int k=1; k<L+1; k++){
                        if(j+k >= N) {
                            // 범위 벗어남
                            isPossible = false;
                            break;
                        } else {
                            if(map[i][j+k] == map[i][j+1]){
                                sameCnt++;
                            } else {
                                isPossible = false;
                                break;
                            }
                        }
                    }

                    if(sameCnt == L){ // 경사로 설치 가능
                        for(int k=1; k<L+1; k++) visited[i][j+k] = true;
                        j += L-1;
                    }
                } else {
                    // 오르막길(지나온 길 체크)
                    // 차이가 1인지 확인
                    if(map[i][j+1] - map[i][j] != 1){
                        isPossible = false;
                        break;
                    }

                    // 내리막길 경사로 겹치는지 확인
                    for(int k=0; k<L; k++){
                        if(j-k < 0 || visited[i][j-k]){
                            isPossible = false;
                            break;
                        }
                    }

                    // 지나온 길 체크
                    if(sameCnt-L >= 0 && isPossible){
                        // 경사로 설치 가능
                        sameCnt = 1;
                        continue;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible) {
                answer++;
            }
        }
    }

    public static void checkVert() {
        for(int i=0; i<N; i++){
            int sameCnt = 1;
            boolean isPossible = true;
            for(int j=0; j<N-1; j++){
                if(map[j][i] == map[j+1][i]) {
                    sameCnt++;
                    continue;
                }
                if(map[j][i] > map[j+1][i]) {
                    // 내리막길(진행방향 체크)
                    // 차이가 1인지 확인
                    if(map[j][i] - map[j+1][i] != 1){
                        isPossible = false;
                        break;
                    }
                    
                    // 진행 방향 체크
                    sameCnt = 0;
                    for(int k=1; k<L+1; k++){
                        if(j+k >= N) {
                            // 범위 벗어남
                            isPossible = false;
                            break;
                        } else {
                            if(map[j+k][i] == map[j+1][i]){
                                sameCnt++;
                            } else {
                                isPossible = false;
                                break;
                            }
                        }
                    }
                    if(sameCnt == L){ // 경사로 설치 가능
                        for(int k=1; k<L+1; k++) visited[j+k][i] = true;
                        j += L-1;
                    }
                } else {
                    // 오르막길(지나온 길 체크)
                    // 차이가 1인지 확인
                    if(map[j+1][i] - map[j][i] != 1){
                        isPossible = false;
                        break;
                    }

                    // 내리막길 경사로 겹치는지 확인
                    for(int k=0; k<L; k++){
                        if(j-k < 0 || visited[j-k][i]){
                            isPossible = false;
                            break;
                        }
                    }

                    // 지나온 길 체크
                    if(sameCnt-L >= 0 && isPossible){
                        // 경사로 설치 가능
                        sameCnt = 1;
                        continue;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible) {
                answer++;
            }
        }
    }
}