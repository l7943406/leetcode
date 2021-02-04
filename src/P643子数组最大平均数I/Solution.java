package P643子数组最大平均数I;

import java.util.Arrays;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        double num = 0;
        for (int i = 0; i < k; i++) {
            num += nums[i];
        }
        ans = Math.max(ans,num);
        for (int i = k; i < nums.length; i++) {
            num = num - nums[i - k] + nums[i];
            ans = Math.max(ans,num);
        }
        return ans/k;
    }
}