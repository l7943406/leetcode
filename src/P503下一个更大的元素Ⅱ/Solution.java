package P503下一个更大的元素Ⅱ;


import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack= new Stack<>();
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]){
                ans[stack.pop()] = nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return ans;
    }
}


