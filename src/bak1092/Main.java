import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        ArrayList<Crane> cranes = new ArrayList<Crane>();
        st = new StringTokenizer(br.readLine());
        int maxCrane = 0;
        for(int i=0; i<n; i++){
            int crane = Integer.parseInt(st.nextToken());
            maxCrane = Math.max(crane, maxCrane);
            cranes.add(new Crane(crane, 0));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        Integer[] boxes = new Integer[m];
        st = new StringTokenizer(br.readLine());
        int maxBox = 0;
        for(int i=0; i<m; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
            maxBox = Math.max(boxes[i], maxBox);
        }

        if(maxBox > maxCrane){
            System.out.println(-1);
            return;
        }

        Collections.sort(cranes, (Crane c1, Crane c2)->{
            return Integer.compare(c2.capacity, c1.capacity);
        });
        Arrays.sort(boxes, Collections.reverseOrder());

        boolean[] moved = new boolean[m];
        Arrays.fill(moved, false);

        int time=0;
        int cnt=0;
        while(true){
            if(cnt == boxes.length) {
                break;
            }
            for(int i=0; i<n; i++){
                while(cranes.get(i).position < boxes.length){
                    if(!moved[cranes.get(i).position] && cranes.get(i).capacity >= boxes[cranes.get(i).position]){
                        moved[cranes.get(i).position] = true;
                        cranes.get(i).position++;
                        cnt++;
                        break;
                    }
                    cranes.get(i).position++;
                }
            }
            time++;
        }

        System.out.println(time);

        br.close();
    }
}

class Crane {
    Integer capacity;
    Integer position;
    public Crane (Integer capacity, Integer position){
        this.capacity = capacity;
        this.position = position;
    }
}