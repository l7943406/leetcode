package 剑指Offer42连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums) {
            sum = Math.max(num,sum + num);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}