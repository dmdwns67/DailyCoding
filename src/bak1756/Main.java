package bak1756;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        Map<Integer, OvenFloor> oven = new HashMap<Integer, OvenFloor>();
        st = new StringTokenizer(br.readLine());
        oven.put(1, new OvenFloor(Integer.parseInt(st.nextToken()), false));
        for(int dept=2; dept<=D; dept++){
            int curDia = Integer.parseInt(st.nextToken();

            if(oven.get(dept-1).diameter < curDia) {
                curDia = oven.get(dept-1).diameter;
            }

            oven.put(dept, new OvenFloor(curDia, false));
        }

        List<Integer> pizzas = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            pizzas.add(Integer.parseInt(st.nextToken()));
        }


        List<Integer> ans = new ArrayList<Integer>();
        for(int order=0; order < pizzas.size(); order++){
            int curPizzaDiameter = pizzas.get(order);
            System.out.println("current Pizza Dia: " + Integer.toString(curPizzaDiameter));

            Iterator<Integer> keys = oven.keySet().iterator();
            while(keys.hasNext()){
                int curIdx = keys.next();
                
                if(oven.get(curIdx).occupied == false && oven.get(curIdx).diameter >=)
            }
        }
        
        Collections.sort(ans);

        // Iterator<Integer> i = oven.keySet().iterator();
        // while(i.hasNext()){
        //     i.next();
        //     System.out.println(Integer.toString(oven.get(i).diameter) +", "+ Boolean.toString(oven.get(i).occupied) );
        // }

        System.out.println(oven);
        System.out.println(ans);

        if(ans.size()!=0) System.out.println(ans.get(0));
        else System.out.println(0);
    }
}

class OvenFloor{
    int diameter;
    boolean occupied;

    public OvenFloor(int diameter, boolean occupied){
        this.diameter = diameter;
        this.occupied = occupied;
    }

}