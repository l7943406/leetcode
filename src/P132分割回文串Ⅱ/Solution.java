package P132分割回文串Ⅱ;

import java.util.Arrays;

class Solution {
    public int minCut(String s) {
        boolean[][] hw = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        Arrays.fill(dp,s.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || hw[j + 1][i - 1])) {
                    hw[j][i] = true;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(hw[0][i]){
                dp[i] = 0;
            }else{
                for (int j = 0; j < i; j++) {
                    if(hw[j + 1][i]){
                        dp[i] = Math.min(dp[i],dp[j] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}