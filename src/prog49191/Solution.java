public class Solution {
    public static void main(String[] args){
        int n = 5;
        int[][] results = {
            {4,3},
            {4,2},
            {3,2},
            {1,2},
            {2,5}
        };

        int answer = solution(n, results);

        System.out.println(answer);
    }

    public static int solution(int n, int[][] results){
        boolean[][] adj = new boolean[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            adj[results[i][0]][results[i][1]] = true;
        }
        
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(i==j || i==k || j==k) continue;
                    
                    if(adj[i][k] && adj[k][j]){
                        adj[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<n+1; i++){
            int cnt = 0;
            for(int j=1; j<n+1; j++){
                if(i == j) continue;
                
                if(adj[i][j] || adj[j][i]) cnt++; // 이긴 기록이나 진 기록이 있는지 체크
            }
            
            if(cnt == n-1){ // 기록이 본인제외하고 나머지 전부 있으면 answer++
                answer++;
            }
        }
        
        return answer;
    }
}