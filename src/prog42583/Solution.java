import java.util.Queue;
import java.util.LinkedList;

class Truck{
    int weight;
    int inTime;
    
    public Truck(int weight, int inTime){
        this.weight = weight;
        this.inTime = inTime;
    }
}

public class Solution {
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        
        int answer = solution(bridge_length, weight, truck_weights);

        System.out.println(answer);
    }    

    public static int solution(int bridge_length, int weight, int[] truck_weights) {   
        Queue<Truck> waiting_trucks = new LinkedList<Truck>();
        Queue<Truck> trucks_on_bridge = new LinkedList<Truck>();
        
        for(int truck_weight : truck_weights){
            waiting_trucks.add(new Truck(truck_weight, 0));
        }
        
        int time = 0;
        int totalWeight = 0;
        while(!waiting_trucks.isEmpty() || !trucks_on_bridge.isEmpty()){
            time++;
            
            if(!trucks_on_bridge.isEmpty()){
                Truck t = trucks_on_bridge.peek();
                if(time - t.inTime >= bridge_length){
                    totalWeight -= t.weight;
                    trucks_on_bridge.poll();
                }
            }
            
            if(!waiting_trucks.isEmpty()){
                if(totalWeight + waiting_trucks.peek().weight <= weight){
                    Truck t = waiting_trucks.poll();
                    totalWeight += t.weight;
                    
                    trucks_on_bridge.add(new Truck(t.weight, time));
                }
            }
        }
        
        return time;
    }
}