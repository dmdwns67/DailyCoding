import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        int[] nums = {3,2,4,4,2,5,2,5,5};
        List<Integer> ans = new ArrayList<Integer>();
        
        ans = Main.count(nums);
        
        System.out.println(ans);
    }

    public static List count(int[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<Integer>(Arrays.asList(-1));
                
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        // map 에 중복값 count
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
            int answer = map.get(keys.next());
            if(answer > 1) ans.add(answer);
        }

        return ans;
    }
}