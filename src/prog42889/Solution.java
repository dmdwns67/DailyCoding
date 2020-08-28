import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};

        int[] result = solution(N, stages);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int N, int[] users) {
        int[] answer = new int[N];
        Stage[] stages = new Stage[N];
        
        for(int i=0; i<N; i++){ 
            // stage 0~N 까지 만들기
            stages[i] = new Stage(i+1);
        }
        
        for(int i=0; i<users.length; i++){
            if(users[i] <= N)   // stage 올클리어 제외
                stages[users[i]-1].cnt++;
        }

        int userCnt = users.length;
        for(int i=0; i<stages.length; i++){
            if(userCnt == 0) { // userCnt가 0이되면 failure에 NaN이 들어감을 방지
                stages[i].failure = 0.0;
            } else {
                stages[i].failure = (double) stages[i].cnt / userCnt;
                userCnt -= stages[i].cnt;
            }
        }
        
        Arrays.sort(stages, (s1, s2) -> {
            if(s1.failure == s2.failure){
                return Integer.compare(s1.idx, s2.idx);
            }
            return Double.compare(s2.failure, s1.failure); 
        });
        
        for(int i=0; i<N; i++){
            answer[i] = stages[i].idx;
        }
        
        return answer;
    }
}

class Stage {
    int idx;
    int cnt;
    double failure;
    public Stage(int idx){
        this.idx = idx;
        this.cnt = 0;
        this.failure = 0.0;
    }
}