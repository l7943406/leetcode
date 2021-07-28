package P698划分为k个相等的子集;

import java.util.Arrays;

class Solution {
    int[] nums;
    boolean[] used;
    int num;
    boolean doIt;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.num = sum / k;
        this.used = new boolean[nums.length];

        int ans = 0;


        for (int j = nums.length - 1; j >= 0; j--) {
            if(!used[j]){
                doIt = false;
                used[j] = true;
                dfs(j - 1,nums[j]);
                ans ++;
                if(!doIt){
                    return false;
                }
            }
        }

        return ans == k;
    }
    public void dfs(int index,int sum){
        if(sum == num){
            doIt = true;
            return;
        }else if(sum > num){
            return;
        }
        for (int i = index; i >= 0; i--) {
            if(!used[i] && !doIt && sum + nums[i] < num){
                used[i] = true;
                dfs(i,sum + nums[i]);
                if(!doIt) {
                    used[i] = false;
                }
            }
        }
    }


}
/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */