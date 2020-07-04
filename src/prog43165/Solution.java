class Solution {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        int answer = solution(numbers, target);

        System.out.println(answer);
    }

    public static int solution(int[] numbers, int target){
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int idx, int num){
        if(idx == numbers.length){
            if(num == target) return 1;
            else return 0;
        } else {
            return dfs(numbers, target, idx+1, num + numbers[idx]) 
                + dfs(numbers, target, idx+1, num - numbers[idx]);
        }
    }

}