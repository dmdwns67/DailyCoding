import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {
    //    System.out.println(Math.pow(5, 2));
    //    System.out.println(5*5);

    //    System.out.println(Math.sqrt(Math.pow(5, 2)));
    //    System.out.println(Math.sqrt(5*5));

       List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(3);
        list.add(12);
        list.add(30);

        Collections.sort(list);

        Collections.sort(list, Collections.reverseOrder());

        Collections.reverse(list);

        Integer[] arr = list.toArray(new Integer[0]);

        System.out.println(Arrays.toString(arr));

        Integer maxVal = Arrays.stream(arr).max(Integer::compare).get();

        System.out.println(maxVal);
    }

}