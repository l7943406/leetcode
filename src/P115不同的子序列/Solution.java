package P115不同的子序列;

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < t.length() + 1; j++) {
                if(j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] = 0;
                }else{
                    if(s.charAt(i - 1) == t.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}