import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
    static int N,M,answer=Integer.MAX_VALUE;
    static List<Location> chickens;
    static List<Location> houses;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 최대 고를 수 있는 치킨집 수

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) { // houses
                    houses.add(new Location(i, j));
                } else if(tmp == 2) { // chickens
                    chickens.add(new Location(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        for(int i=0; i<chickens.size(); i++) {
            selectChickens(0, i, 0, "");
        }

        System.out.println(answer);

        br.close();
    }

    public static void selectChickens(int start, int r, int depth, String test) {
        if(depth == M) { // depth가 M일 때만 체크해도, 치킨 거리 구할 때 이미 M보다 작은 경우도 고려됨.
            // System.out.println("chickens: " + test);
            answer = Math.min(answer, getCityChickenDis());
            // System.out.println("minNum: " +answer);
            return; 
        }

        for(int i=start; i<chickens.size(); i++) {
            visited[i] = true;
            selectChickens(i+1, r-1, depth+1, test + Integer.toString(i));
            visited[i] = false;
        }       
    }

    public static int getCityChickenDis() {
        int sum = 0;
        for(Location house : houses) {
            int dis = Integer.MAX_VALUE;
            for(int i=0; i<chickens.size(); i++) {
                if(!visited[i]) continue;
                dis = Math.min(dis, calDistance(house, chickens.get(i)));
            }
            sum += dis;
        }
        return sum;
    }

    public static int calDistance(Location l1, Location l2) {
        return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
    }
}

class Location {
    int x,y; 
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
