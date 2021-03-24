package P456132模式;

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        int num2 = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < num2){
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                num2 = stack.pop();
            }
            if(nums[i] > num2) {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}