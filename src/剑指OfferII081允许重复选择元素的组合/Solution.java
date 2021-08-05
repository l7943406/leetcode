package 剑指OfferII081允许重复选择元素的组合;

import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int min = 201;
        for(int candidate : candidates){
            if(candidate < min){
                min = candidate;
            }
        }
        int[][] dp = new int[(target + min - 1) / min + 1][target - min];
        int n = (target + min - 1) / min + 1;
        for(int i : candidates){
            if(i <= target) {
                dp[0][i - min]++;
            }
        }
        for (int i = 0; i < n - 1; i++) {

        }


return null;



    }
}

/*

给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。

candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

对于给定的输入，保证和为target 的唯一组合数少于 150 个。

 */