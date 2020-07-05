public class Solution {
    public static void main(Stirng[] args) {
        int n = 78;

        int result = solution(n);

        System.out.println(result);
    }   

    public static int solution(int n){
        int curCnt = countOneFromBinaryNum(n);
        
        int nextCnt = -1;
        while(true){
            nextCnt = countOneFromBinaryNum(++n);
            if(curCnt == nextCnt) {
                break;
            }
        }
        
        return n;
    }

    public static int countOneFromBinaryNum(int n){
         // n%2 == 1 체크 및 n/2 처리하면서 계산했더니 시간 초과 걸림. toBinaryStrin() 사용하니 통과.
         String nToBinary = Integer.toBinaryString(n);
         int cnt = 0;
         for(int i=0; i<nToBinary.length(); i++){
             if(nToBinary.charAt(i) == '1') cnt++;
         }
         return cnt;
    }
}