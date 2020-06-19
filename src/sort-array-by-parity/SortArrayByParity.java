public class SortArrayByParity {

    public static void main(String[] args){
        int[] nums = {3,1,2,4};
		
        SortArrayByParity.sort(nums);
 
        for (int num : nums){
            System.out.println(num);
        }
    }

    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int i = 0;
        int j = nums.length-1;

        while(i < j){
             
            if(nums[i]%2 == 1 && nums[j]%2 == 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

            if(nums[i]%2 == 0) i++;
            if(nums[j]%2 == 1) j--;
        }
        
        return nums;
    }

}