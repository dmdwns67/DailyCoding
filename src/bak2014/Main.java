import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        Long[] arr = new Long[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i] = Long.parseLong(st.nextToken());
            pq.add(arr[i]);
        }

        Long ith = Long.valueOf(1);
        Long num = Long.valueOf(0);
        while(ith <= N) {
            num = pq.poll();
            ith++;
            for(Long next : arr){
                pq.add(num*next);
                // 중복 방지 : 이거 없으면 메모리 초과
                // 2가 poll 됐을 때는 2*2, 3이 poll 됐을 때는 3*2, 3*3만 추가되도록 구현
                if(num % next == 0){
                    break;
                }
            }
        }
        
        System.out.println(num);

        br.close();
    }
}