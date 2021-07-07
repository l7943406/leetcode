package P39组合总和;

import java.util.Arrays;
import java.util.List;

//class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int min = Integer.MAX_VALUE;
//        int[][] dp = new int[target / min + 1][target + 1];
//        for (int i = 0; i < candidates.length; i++) {
//            dp[0][i] = 1;
//            min = Math.min(min,candidates[i]);
//        }
//
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                if(dp[i][j] > 0){
//                    for (int k = 0; k < candidates.length; k++) {
//                        if(dp[i - 1][j])
//                            int num = dp[i - 1][j] + candidates[k];
//                        if(num <= target){
//                            dp[i][num] ++;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}