import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static boolean[] visited;
    static String route ="";
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args){
        String[][] tickets = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        };

        String[] answer = solution(tickets);

        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[][] tickets) {
        for(int i=0; i<tickets.length; i++){
            visited = new boolean[tickets.length];
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(start.equals("ICN")){
                route = start + " ";
                visited[i] = true;
                dfs(tickets, end, 1);
            }
        }
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    public static void dfs(String[][] tickets, String end, int cnt){
        route += end + " ";
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            String s = tickets[i][0];
            String e = tickets[i][1];
            if(s.equals(end) && !visited[i]){
                visited[i] = true;
                dfs(tickets, e, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}