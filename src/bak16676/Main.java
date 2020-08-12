import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        
        long S = getS(Long.toString(N).length(), 1);

        // System.out.println(
        //     "N : " + N + ", S : " + S
        // );

        if(Long.toString(N).length() == 1) System.out.println(1);
        else if(N >= S) System.out.println(Long.toString(N).length());
        else System.out.println(Long.toString(N).length()-1);

        sc.close();
    }

    // ~10 : 1장
    // ~110 : 2장
    // ~1110 : 3장 ....
    // n의 자릿수에 따라 1로 치환해서 반환. ex) n이 1000이면 1111를 리턴
    public static long getS(long n, long num){
        if(n == 0){
            return num/10;
        }
        
        return getS(n-1, num*10+1);
    } 
}