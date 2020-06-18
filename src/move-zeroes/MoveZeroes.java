public class MoveZeroes {

    public static void main(String[] args){
        int[] nums = {0,1,3,0,12};
		
		MoveZeroes.moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
                
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
        
        for(int num :nums){
        	System.out.print(num+" ");
        }
    }
}