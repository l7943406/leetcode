package P583两个字符串的删除操作;

class Solution {
    public int minDistance(String word1, String word2) {
        byte[] s1 = word1.getBytes();
        byte[] s2 = word2.getBytes();
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i] == s2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return s1.length + s2.length -  2 *dp[s1.length][s2.length];
    }
}