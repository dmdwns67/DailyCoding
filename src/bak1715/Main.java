import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i=0; i<N; i++){
            q.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(q.size() >= 2){
            int num1 = q.poll();
            int num2 = q.poll();
            q.offer(num1+num2);
            sum += (num1+num2);
        }

        System.out.println(sum);

        br.close();
    } 
}