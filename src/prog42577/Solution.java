
public class Solution {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean answer = solution(phone_book);

        System.out.println(answer);
    }

    public static boolean solution(String[] phone_book){

        for(int i = 0 ; i < phone_book.length; i++){
            String cur = phone_book[i];
            for(int j=0; j<phone_book.length; j++){
                if( i != j && ( cur.length() <= phone_book[j].length() ) ) {
                    String comp = phone_book[j].substring(0, cur.length());
                    if(cur.equals(comp)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}