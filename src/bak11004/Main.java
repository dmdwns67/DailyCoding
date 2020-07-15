import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] answer = mergeSort(arr);

        System.out.println(answer[K-1]);

        br.close();
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        
        int i = 0, j=0, k = 0;
        while(i<left.length && j <right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        if(i == left.length){
            while(j < right.length){
                arr[k] = right[j];
                j++;
                k++;
            }
        } else if (j == right.length){
            while(i < left.length){
                arr[k] = left[i];
                i++;
                k++;
            }
        }
        return arr;
    }
}