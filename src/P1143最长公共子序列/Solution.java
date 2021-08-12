package P1143最长公共子序列;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()){
            return 0;
        }
        byte[] s1 = text1.getBytes();
        byte[] s2 = text2.getBytes();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(s1[i - 1] == s2[j - 1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }



        return dp[dp.length - 1][dp[0].length - 1];
    }
}
/*

"abcde"
"ace"

 i 0 1 2
j0 0 0 0
 1 0 0 0
 2 0 1 1
 3 0 0 1
 4 0 0 1

s1:i-s1.len - s2:j-s2.len 最长的公共子序列
 */