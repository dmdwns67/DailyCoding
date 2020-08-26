import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int s = 15;
        int[] answer = solution(n, s);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int n, int s) {
        // n>s이면, n 개의 자연수로 합이 s 인 집합을 만들 수 없다.
        if(n > s) return new int[] {-1};
        
        // 중간값에 가까운 값끼리 곱했을 때 값이 가장 크므로, 합을 n으로 나눠준다.
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = s/n;
        }
        
        // s%n의 횟수만큼 answer의 원소값에 1씩 더해준다. 단, 오름차순 정렬을 위해 뒤부터.
        for(int i=0; i<s%n; i++){
            answer[answer.length-1-i]++;
        }
        
        return answer;
    }
}