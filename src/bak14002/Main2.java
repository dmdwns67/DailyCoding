import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// ㅜㅜ 아.... 합이 최대값인 수열을 역추적하고 있었네!!
public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] dp = new Integer[N]; /// dp[i]는 arr에서 i번까지 왔을 때 합의 최대값
        for(int i=0; i<arr.length; i++){
            dp[i] = arr[i];
        }

        int[] rev = new int[N];
        for(int i=0; i<N; i++){
            rev[i] = i;
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[i] < arr[i]+dp[j]){
                    dp[i] = arr[i]+dp[j];
                    rev[i] = j;
                }
            }
        }

        Integer max = Arrays.stream(dp).max(Integer::compare).get(); 
        //int idx = Arrays.asList(dp).indexOf(max); // max가 다수일 수 있다.
        int idx = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            if(dp[i] == max){
                idx = Math.max(idx, i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(rev[idx] != idx){
            answer.add(arr[idx]);
            idx = rev[idx];
        }
        answer.add(arr[idx]);
        
        Collections.reverse(answer);

        System.out.println(answer.size());
        for(Integer i : answer){
            System.out.print(i + " ");
        }

        br.close();
    }
}