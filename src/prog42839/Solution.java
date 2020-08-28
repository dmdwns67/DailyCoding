import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args){
        String numbers = "011";

        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        char[] numToChar = numbers.toCharArray();
        int[] numCard = new int[numbers.length()];
        for(int i=0; i<numCard.length; i++){
            numCard[i] = Integer.parseInt(String.valueOf(numToChar[i]));
        }
        
        Set<Integer> primes = new HashSet<>();
        for(int i=1; i<numbers.length()+1; i++){
            perm(numToChar, 0, i, primes);
        }
        
        // System.out.println("size: "+ primes.size());
        
        return primes.size();
    }
    
    public static void perm(char[] arr, int depth, int digit, Set primes){
        if(depth == digit){
            String str = "";
            for(int i=0; i<digit; i++){
                str += arr[i];
            }
            if(isPrime(Integer.parseInt(str))){
                primes.add(Integer.parseInt(str));
            }
        } else {
            for(int i=depth; i<arr.length; i++){
                swap(arr, i, depth);
                perm(arr, depth+1, digit, primes); 
                swap(arr, i, depth);
            }
        }
    }
    
    public static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
            if(i*i > num) break;
        }
        return true;
    }
}