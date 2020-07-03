class Solution {

    public static void main(String[] args){
        int p1 = 10;
        int p2 = 2;

        int[] answer = solution(p1, p2);

        for(int e : answer) {
            System.out.print(e+" ");
        }
    }

    public static int[] solution(int brown, int yellow){
        int sum = brown + yellow;

        // at least 3 rows because of '1 <= yellow <= 2,000,000', so at most sum/3 cols.
        for( int vertical=3; vertical<=sum/3; vertical++) {
            if(sum % vertical == 0){
                int horizon = sum / vertical;
                if( (vertical-2)*(horizon-2) == yellow ) {
                    return new int[] {horizon, vertical};
                }
            }
        }

        return new int[] {};
    }
}