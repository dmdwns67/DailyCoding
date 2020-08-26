import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        int n = 6;
        int[] times = {7, 10};

        long answer = solution(n, times);

        System.out.println(answer);
    }

    public static long solution(int n, int[] times){
        long answer = Long.MAX_VALUE;
        long left = 0, right = 0;

        // 제일 오래 걸리는 심사관이 n명을 심사했을 때가 최대 심사 시간
        right = Arrays.stream(times).max().getAsInt() * n;

        while(left <= right){
            long people = 0;
            long mid = (left + right) / 2;

            for(int time : times){
                people += mid / time;
            }

            if(people < n){
                // mid 시간 동안 전체 n명을 다 심사하지 못한 경우, 시간이 더 필요하므로 left 증가
                left = mid + 1;
            } else {
                // n명을 다 처리한 경우, 최소 시간을 구해야 하므로 right 감소
                right = mid - 1;
                // 처리 가능한 시간의 최솟값 갱신
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}