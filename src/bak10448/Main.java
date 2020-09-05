import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] arr = new int[50];
        
        int sum = 2;
        arr[0] = 1;
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1] + sum;
            sum++;
        }

        boolean[] isTriangleNum = new boolean[1001]; // 3~1000까지 3개의 합으로 표현 가능한 수

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr.length; k++){
                    int idx = arr[i] + arr[j] + arr[k];
                    if(idx > 1000) continue;
                    else isTriangleNum[idx] = true;
                }
            }
        }

        for(int i=0; i<testCase; i++){
            int num = sc.nextInt();
            if(isTriangleNum[num]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}
