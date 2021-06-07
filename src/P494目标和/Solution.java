package P494目标和;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] ++;
        dp[0][-nums[0] + 1000] ++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < dp[i].length ; j++) {
                if(dp[i - 1][j] != 0){
                    dp[i][j - nums[i]] += dp[i - 1][j];
                    dp[i][j + nums[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target+1000];
    }
}