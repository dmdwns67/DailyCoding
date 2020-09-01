import java.util.Scanner;

public class Main {
    static int N, minVal=Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] group;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        ability = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                ability[i][j] = sc.nextInt();
            }
        }
        group = new boolean[N+1]; // false : 스타트 팀, true : 링크 팀

        dfs(0, 1);

        System.out.println(minVal);

        sc.close();
    }

    public static void dfs(int cnt, int idx){
        if(cnt == N/2){
            minVal = Math.min(minVal, getGroupDiff());
        }

        for(int i=idx; i<N+1; i++){
            if(!group[i]) {
                group[i] = true; // 링크팀이라 치고...
                dfs(cnt+1, i);
                group[i] = false; // 원상복귀
            }
        }
    }

    public static int getGroupDiff(){
        int linkSum = 0; // group이 true
        int startSum = 0; // group이 false

        for(int i=1; i<N+1; i++){
            for(int j=i; j<N+1; j++){
                if(i==j) continue;

                if(group[i] && group[j]){
                    linkSum += ability[i][j] + ability[j][i];
                }
                if(!group[i] && !group[j]){
                    startSum += ability[i][j] + ability[j][i];
                }
            }
        }
        // System.out.println(Math.abs(linkSum - startSum));
        return Math.abs(linkSum - startSum);
    }


}