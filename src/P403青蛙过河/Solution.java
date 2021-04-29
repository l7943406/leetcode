package P403青蛙过河;


class Solution {
    public boolean canCross(int[] stones) {
        for (int i = 1; i < stones.length; i++) {
            if(stones[i] - stones[i - 1] > i){
                return false;
            }
        }
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1;j >= 0 &&  stones[i] - stones[j] <= j + 1 ; j--) {
                int k = stones[i] - stones[j];
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
            }
        }


        for (int i = 0; i < stones.length; i++) {
            if(dp[stones.length - 1][i]){
                return true;
            }
        }
        return false;
    }
}
