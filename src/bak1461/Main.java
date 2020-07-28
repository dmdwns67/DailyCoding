import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int largest = 0;
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(st.nextToken());
            largest = Math.max((int)Math.abs(val), largest);
            arr.add(val);
        }

        PriorityQueue<Integer> positive = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        PriorityQueue<Integer> negative = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));

        for(int position : arr){
            if(position > 0){
                positive.add(position);
            } else {
                negative.add(position * (-1));
            }
        }

        int result = 0;

        while(!positive.isEmpty()){
            result += positive.poll();
            for(int i=0; i<M-1; i++){
                positive.poll();
            }
        }

        while(!negative.isEmpty()){
            result += negative.poll();
            for(int i=0; i<M-1; i++){
                negative.poll();
            }
        }

        System.out.println(result*2 - largest);

        br.close();
    }
}