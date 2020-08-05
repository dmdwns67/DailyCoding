import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] map = new char[R][C];
        for(int i=0; i<R; i++){
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean chk = false;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'W'){
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx == R || ny < 0 || ny == C){
                            continue;
                        }
                        if(map[nx][ny] == 'S'){
                            chk = true;
                        }
                    }
                }
            }
        }

        if(chk){
            System.out.println(0);
        } else {
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] == '.'){
                        map[i][j] = 'D';
                    }
                }
            }

            System.out.println(1);
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

        sc.close();
    }
}