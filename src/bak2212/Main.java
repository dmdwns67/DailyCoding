import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        if(K >= N){
            System.out.println(0);
            return;
        }

        ArrayList<Integer> sensors = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sensors.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(sensors);

        ArrayList<Integer> distances = new ArrayList<>();
        for(int i=1; i<N; i++){
            distances.add(sensors.get(i)-sensors.get(i-1));
        }

        Collections.sort(distances, Collections.reverseOrder());

        for(int i=0; i<K-1; i++){
            distances.set(i, 0);
        }

        int sum = 0;
        for(int distance : distances){
            sum += distance;
        }

        System.out.println(sum);

        br.close();
    }
}