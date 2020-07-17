import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> books = new HashMap<String, Integer>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String book = br.readLine();
            if(books.containsKey(book)){
                books.put(book, books.get(book)+1);
            } else {
                books.put(book, 1);
            }
        }

        ArrayList<String> answer = new ArrayList<String>();

        int max = Collections.max(books.values());

        for(Entry<String, Integer> entry : books.entrySet()){
            if(entry.getValue() == max){
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);

        System.out.println(answer.get(0));

        br.close();
    }
}