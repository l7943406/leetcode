package P581最短无序连续子数组;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            nums[i] = max;

            min = Math.min(min,copy[nums.length - i - 1]);
            copy[nums.length - i - 1] = min;
        }


        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != copy[i]){
                left = i;
                break;
            }
        }
        if(left == -1){
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] != copy[i]){
                right = i;
                break;
            }
        }
        return right - left + 1;

    }


}
/*

给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

2 6 6 8 10 10 15
2 4 4 8 9 9 15
 */