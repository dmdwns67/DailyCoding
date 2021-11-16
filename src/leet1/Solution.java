package leet1;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] answer = solution(nums, target);

        for(int i =0; i< answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[] {};
    }
}