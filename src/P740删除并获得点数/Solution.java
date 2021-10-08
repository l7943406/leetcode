package P740删除并获得点数;


class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for(int num : nums){
            dp[num] ++;
        }
        if(dp.length <= 2){
            return dp[1];
        }

        dp[2] *= 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i] * i + Math.max(dp[i - 2],dp[i  - 3]);
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);



    }

}
/*
给你一个整数数组nums，你可以对它进行一些操作。

每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。

开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

 */