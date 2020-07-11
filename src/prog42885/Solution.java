import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        int[] people = {70,50,80,50};
        int limit = 100;

        int answer = solution(people, limit);

        System.out.println(answer);
    } 

    public static int solution(int[] people, int limit){
        int answer = 0;
        Arrays.sort(people);

        int i=0, j=0;
        for(j=people.length-1; i<j; j--){
            if(people[i]+people[j] > limit){
                // go heavier person first
                answer++;
            } else{
                // go together
                answer++;
                i++;
            }
        }

        if(i==j) answer++;

        return answer;
    }
}