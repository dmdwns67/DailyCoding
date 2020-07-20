import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!q.isEmpty()) {System.out.println(q.poll());}
                else {System.out.println(0);}
            } else {
                q.offer(x);
            }
        }

        br.close();
    }
}