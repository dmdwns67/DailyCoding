public class Solution {
    public static void main(String[] args){
        String name = "JAN";

        int answer = solution(name);

        System.out.println(answer);
    }

    public static int solution(String name){
        int answer = 0;
        /*
        cnt  |   0   1   2   3   4   5   6   7   8   9   10  11  12  |   13  14  15  16  17  18  19  20  21  22  23  24  25
        num  |   65  66  67  68  69  70  71  72  73  74  75  76  77  |   78  79  80  81  82  83  84  85  86  87  88  89  90
        char |   A   B   C   D   E   F   G   H   I   J   K   L   M   |   N   O   P   Q   R   S   T   U   V   W   X   Y   Z
        */
        int cursorMove = name.length()-1;
        for(int i=0; i<name.length(); i++){
            if (name.charAt(i) < 78){
                answer += name.charAt(i)%65;
            } else {
                answer += 91-name.charAt(i);
            }

            if(name.charAt(i) != 'A'){
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A'){
                    next++;
                }
                int reverseMove = 2*i + (name.length() - next);
                cursorMove = Math.min(cursorMove, reverseMove);
            }
        }

        return answer + cursorMove;
    }
}