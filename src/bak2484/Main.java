import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i=0; i<N; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            int money = getMoney(arr);
            answer = Math.max(answer, money);
        }

        System.out.println(answer);

        br.close();
    }

    public static int getMoney(ArrayList<Integer> arr){
        HashSet<Integer> hs = new HashSet<Integer>(arr);
        
        // case 1: 같은 눈 4개
        if(hs.size() == 1){
            return arr.get(0)*5000 + 50000;
        }

        // case 2 & 3: 같은 눈 3개 또는 같은 눈이 2개씩 두 쌍
        if(hs.size() == 2){
            if(arr.get(1) == arr.get(2)){
                return arr.get(1)*1000 + 10000;
            } else {
                return (arr.get(1)+arr.get(2))*500 + 2000;
            }
        }

        // case 4: 같은 눈이 2개만 나오는 경우
        for(int i=0; i<3; i++){
            if(arr.get(i) == arr.get(i+1)){
                return arr.get(i)*100 + 1000;
            }
        }

        // case 5: 모두 다른 눈
        return arr.get(arr.size()-1) * 100;
    }
}