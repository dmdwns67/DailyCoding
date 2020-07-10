import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Print{
    int idx;
    int importance;

    public Print(int idx, int importance){
        this.idx = idx;
        this.importance = importance;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++){
            int N = sc.nextInt();
            int IDX = sc.nextInt();

            Queue<Print> printer = new LinkedList<Print>();

            List<Integer> importanceList = new ArrayList<Integer>();
            for(int j=0; j<N; j++){
                int importance = sc.nextInt();
                importanceList.add(importance);
                printer.add(new Print(j, importance));
            }

            Collections.sort(importanceList, (e1, e2)->{
                return Integer.compare(e1, e2);
            }); // asc

            int cnt = 0;
            while(!printer.isEmpty()){
                if(printer.peek().importance == importanceList.get(importanceList.size()-1)){
                    Print isAnswer = printer.poll();
                    cnt++;
                    if(isAnswer.idx == IDX){
                        System.out.println(cnt);
                        break;
                    }
                    importanceList.remove(importanceList.size()-1);
                } else {
                    printer.add(printer.poll());
                }
            }
        }

        sc.close();
    }
}