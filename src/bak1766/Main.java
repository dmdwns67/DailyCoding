import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javafx.scene.layout.Priority;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> rule = new HashMap<Integer, ArrayList<Integer>>();
        int[] inDegree = new int[N+1]; // 진입차수

        Arrays.fill(inDegree, 0);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int preceding = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr;
            if(rule.get(preceding) == null) {
                arr = new ArrayList<Integer>();
                arr.add(curr);
                rule.put(preceding, arr);
            } else {
                arr = rule.get(preceding);
                arr.add(curr);
                rule.put(preceding, arr);
            }

            inDegree[curr]++;
        }

        // 위상정렬 사용. 진입차수 0인 노드들을 Q에 넣는다.
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=1; i<N+1; i++){
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int data = q.poll();
            result.add(data);
            if(rule.get(data) != null){
                for(int book : rule.get(data)){
                    inDegree[book]--;
                    if(inDegree[book] == 0){
                        q.add(book);
                    }
                }
            }
        }

        for(int book : result){
            System.out.print(book+" ");
        }

        br.close();
   }
}