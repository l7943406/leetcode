package P516最长回文子序列;

class Solution {
    public int longestPalindromeSubseq(String s) {
        byte[] bytes = s.getBytes();
        int[][]dp = new int[bytes.length][bytes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = bytes.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < bytes.length; j++) {
                if(bytes[i] == bytes[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[0][bytes.length - 1];
    }
}
/*
0123456
abbccca
    i
   j0 0 1 2 3 4 5 6
    0 1 1 2 2 2 3 5
    1 0 1 2 2 2 3 3
    2 0 0 1 1 2 3 3
    3 0 0 0 1 2 3 3
    4 0 0 0 0 1 2 2
    5 0 0 0 0 0 1 1
    6 0 0 0 0 0 0 1
 */




/*

给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

 */