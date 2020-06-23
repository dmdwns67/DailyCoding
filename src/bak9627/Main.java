package bak9627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            if(i == N-1) {
                sb.append(st.nextToken());
            } else {
                sb.append(st.nextToken()  + " ");    
            }
        }

        String param1 = sb.toString();
        int param2 = sb.toString().trim().replaceAll(" ", "").replace("$","").length();

        //System.out.println(param1);
        //System.out.println(param2);

        Main.match(param1, param2);
    }

    public static void match(String str, int strLen){
        String DIGIT[][] = {
            // 1~9
            {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
            // 10~19
            {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
            // others
            {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}
        };

        for(int num=strLen; num<1000; num++) {
            // STEP1. Calculate length of each number
            int i = num;
            StringBuilder sb = new StringBuilder();

            if(num >= 100) {
                sb.append(DIGIT[0][i/100] + "hundred");
                i = i % 100;
            }

            if(i < 10) sb.append(DIGIT[0][i]);
            else if( i >= 10 && i < 20) sb.append(DIGIT[1][i%10]);
            else sb.append(DIGIT[2][i/10] + DIGIT[0][i%10]);

            int dollarLen = sb.length();

            // STEP2. Check if the number is answer
            if(dollarLen + strLen == num) {
                // this is correct answer
                System.out.println( str.replace("$", sb.toString()) );

                // there is no mention about multiple answer.
                // Ex) blah blah fifteen && blah blah seventeen.
            }
        }

    }

}