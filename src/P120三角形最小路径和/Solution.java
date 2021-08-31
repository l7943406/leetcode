package P120三角形最小路径和;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);
            for (int j = 1; j < list.size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + list.get(j);
            }
            dp[i][list.size() - 1] = list.get(list.size() - 1) + dp[i - 1][list.size() - 2];
        }
        int min = Integer.MAX_VALUE;
        for(int i : dp[dp.length - 1]){
            min = Math.min(i,min);
        }
        return min;
    }
}