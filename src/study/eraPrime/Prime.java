import java.util.ArrayList;
import java.util.Arrays;

public class Prime {
    
    public static void main(String[] args) {

        int num = 0;

        // 1. 소수 체크 기본(O(log N))
        num = 17;
        System.out.println(isPrime(num));
        num = 16;
        System.out.println(isPrime(num));


        // 2. 소인수분해 기본(O(log N))
        num = 15;
        ArrayList<Integer> arr = primeFactorization(num);
        print(arr);

        // 3. 에라토스테네스의 체를 활용한 소수 리스트(O(N log log N))
        num = 12;
        arr = eratos(num);
        print(arr);
        
        // 4. 에라토스테네스의 체를 활용한 소인수분해
        num = 10;
        ArrayList<Integer> primes = eratos(num);
        arr = primeFactorizationEratos(num, primes);
        print(arr);

        
        // 5. 에라토스테네스 활용 - 약수의 개수
        num = 10;
        arr = eraFactorCount(num);
        print(arr);

        // 6. 에라토스테네스 활용 - 약수의 합
        num = 10;
        arr = eraFactorSum(num);
        print(arr);

        // 7. 에라토스테네스 활용 - 가장 큰 소수 구하기 및 소인수분해
        num = 100;
        arr = eraFactorLargest(num);
        // 가장 큰 소수
        // print(arr); 
        // 소인수분해 하기
        int N = 84;
        while(arr.get(N) != 0){
            System.out.print(arr.get(N)+" ");
            N /= arr.get(N);
        }
        

    }

    // 1. 소수 체크 기본
    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
            if(i*i > num) break;
        }
        return true;
    }

    // 2. 소인수(소수인 약수)분해 기본
    public static ArrayList<Integer> primeFactorization(int num){
        int p = 2;
        ArrayList<Integer> fac = new ArrayList<>();
        
        while(Math.pow(p, 2) <= num){
            if(num%p == 0){
                num /= p;
                fac.add(p);
            } else {
                p++;
            }
        }

        if(num > 1) fac.add(num);

        return fac;
    }

    // 3. 에라토스테네스의 체를 활용한 소수 리스트
    public static ArrayList<Integer> eratos(int num){
        ArrayList<Integer> primes = new ArrayList<>();
        int[] arr = new int[num+1];
        for(int i=2; i<num; i++){
            if(arr[i] == 0) {
                // 0인 경우 소수.
                primes.add(i);
            } else {
                continue;
            }

            for(int j=(int)Math.pow(i, 2); j<num; j=j+i){
                arr[j] = 1;
            }
        }
        return primes;
    }

    // 4. 에라토스테네스의 체를 활용한 소인수분해
    public static ArrayList<Integer> primeFactorizationEratos(int num, ArrayList<Integer> p){
        ArrayList<Integer> fac = new ArrayList<>();
        for(Integer i : p){
            if(num == 1 || Math.pow(i, 2) > num) break;
            while(num % i == 0){
                fac.add(i);
                num /= i;
            }
        }
        if(num>1) fac.add(num);
        return fac;
    }

    // 5. 에라토스테네스 활용 - 약수의 개수
    public static ArrayList<Integer> eraFactorCount(int num){
        Integer[] arr = new Integer[num+1];
        Arrays.fill(arr, 0);
        for(int i=1; i<num+1; i++){
            for(int j=i; j<num+1; j+=i){
                arr[j] += 1;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    // 6. 에라토스테네스 활용 - 약수의 합
    public static ArrayList<Integer> eraFactorSum(int num){
        Integer[] arr = new Integer[num+1];
        Arrays.fill(arr, 0);
        for(int i=1; i<num+1; i++){
            for(int j=i; j<num+1; j+=i){
                arr[j] += i;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    // 7. 에라토스테네스 활용 - 가장 큰 소수 구하기
    public static ArrayList<Integer> eraFactorLargest(int num){
        Integer[] arr = new Integer[num+1];
        Arrays.fill(arr, 0);
        for(int i=2; i<num; i++){
            if(arr[i] != 0) continue;
            for(int j=i; j<num; j+=i){
                arr[j] = i;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    public static void print(ArrayList<Integer> arr){
        for(Integer n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}