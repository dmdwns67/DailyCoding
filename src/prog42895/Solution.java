/* 
 * 참고 링크: https://eoghks0521.tistory.com/entry/N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4
 */
class Solution {
    static int answer = -1;

    public static void main(String[] arg){
        int N = 5;
        int number = 12;

        int minCnt = solution(N, number);

        System.out.println(minCnt);
    }

    public static int solution(int N, int number){
        dfs(N, number, 0, 0);
        return answer;
    }

    public static void dfs(int N, int number, int cnt, int target) {
        if(cnt > 8) {
            answer = -1;
            return;
        }
        
        if(target == number){
            if(answer == -1 || answer > cnt){
                answer = cnt;
            }
            return;
        }
        
        int nextN = N;
        for(int i=0; i<8-cnt; i++){
            dfs(N, number, cnt+i+1, target-nextN);
            dfs(N, number, cnt+i+1, target+nextN);
            dfs(N, number, cnt+i+1, target*nextN);
            if(nextN !=0) dfs(N, number, cnt+i+1, target/nextN);
            
            nextN = nextN*10 + N;
        }
    }

}