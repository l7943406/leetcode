package P673最长递增子序列的个数;

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,1);
        Arrays.fill(dp,1);
        int max = 1;
        int ans = 1;


        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                   dp[i] = Math.max(dp[i],dp[j] + 1);
                   if(dp[i] > max){
                       max = dp[i];
                       ans = 1;
                   }else if(dp[j] + 1 == max){
                       ans++;
                   }
                }
            }

        }
        if(max == 1){
            return nums.length;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
/*
[1,2,4,3,5,4,7,2]
 */