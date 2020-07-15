import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int N = Integer.parseInt(br.readLine());

            solution(1, N, "1");

            System.out.println();
        }
        
        br.close();
    }

    public static void solution(int cnt, int n, String result) throws ScriptException{
            if(cnt == n){
                // First, I used eval() method in JavaScript engine, but TIMEOUT occured
                int tmp = (int)engine.eval(result.replaceAll(" ", ""));
                if( tmp == 0){
                    System.out.println(result);
                }
                return;
            }

            solution(cnt+1, n, result + " " +Integer.toString(cnt+1));
            solution(cnt+1, n, result + "+" +Integer.toString(cnt+1));
            solution(cnt+1, n, result + "-" +Integer.toString(cnt+1));
    }
}