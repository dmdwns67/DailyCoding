import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트케이스 개수

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 애들 숫자
            Integer[] children = new Integer[N];        // 애들이 가진 사탕 수 초기값
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                children[j] = Integer.parseInt(st.nextToken());
            }
/* 
            // 체크 함수 확인용
            System.out.println(check(children));

            // 순환 전 값 체크
            for(Integer candy : children) {
                System.out.print(candy + " ");
            }
            System.out.println();
            
            // 순환 1회 실시
            handleCandy(children);

            // 순환 후 결과값 체크
            for(Integer candy : children) {
                System.out.print(candy + " ");
            }
            System.out.println();
*/
            int cnt = 0;
            while(!check(children)){
                cnt++;
                handleCandy(children);
            }
            
            System.out.println(cnt);
        }

        br.close();
    }

    /*
     * handleCandy : 캔디를 오른쪽 사람에게 전달하는 함수
     * Parameter : arr - 아이들이 가진 사탕 수 
     */
    public static void handleCandy(Integer[] arr){
        Integer[] recvCandy = new Integer[arr.length];
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 1){
                arr[i]++;
            }
            arr[i] /= 2;
            recvCandy[(i+1)%arr.length] = arr[i];
        }

        for(int i=0; i<arr.length; i++){
            arr[i] += recvCandy[i];
        }
    }

    /*
     * check : 애들이 사탕을 동일하게 가졌는지 판단 후 T/F 반환하는 함수
     * Parameter : arr - 아이들이 가진 사탕 수
     */
    public static boolean check(Integer[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 == 1){
                arr[i]++;
            }
        }

        Set<Integer> hs = new HashSet<Integer>();
        Collections.addAll(hs, arr);

        return hs.size() == 1;
    }
}