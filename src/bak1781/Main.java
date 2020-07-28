import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        ArrayList<Problem> problems = new ArrayList<>();
        for(int i=0; i<N; i++){
            int deadLine = sc.nextInt();
            int cupRamen = sc.nextInt();
            problems.add(new Problem(deadLine, cupRamen));
        }

        Collections.sort(problems, (c1, c2) -> Integer.compare(c1.deadLine, c2.deadLine));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Problem p : problems){
            pq.add(p.cupRamen);
            if(p.deadLine < pq.size()){
                pq.poll();
            }
        }

        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);

        sc.close();
    }
}

class Problem {
    int deadLine;
    int cupRamen;
    public Problem(int deadLine, int cupRamen){
        this.deadLine = deadLine;
        this.cupRamen = cupRamen;
    }
}