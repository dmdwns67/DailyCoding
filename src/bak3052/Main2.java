import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<10; i++){
            int num = sc.nextInt()%42;

            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map.size());
        sc.close();
    }
}