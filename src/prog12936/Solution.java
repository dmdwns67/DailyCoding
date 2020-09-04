import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(Arrays.toString(solution(n, k)));
    }

    public static int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long fac = 1;
        for(int i=1;i<=n;i++) {
            fac*=i;
            list.add(i);
        }
        
        k--;
        int idx = 0;
        int[] result = new int[n];
        while(n>0) {
            fac /= n--; 
            result[idx] = list.get((int) (k/fac));
            list.remove((int) (k/fac));
            k %= fac; 
            idx++;
        }
        return result;
    }
}