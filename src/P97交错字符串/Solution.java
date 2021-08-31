package P97交错字符串;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }


        byte[] a1 = s1.getBytes();
        byte[] a2 = s2.getBytes();
        byte[] a3 = s3.getBytes();

        boolean[][] dp = new boolean[a1.length + 1][a2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= a1.length; i++) {
            if(a1[i - 1] == a3[i - 1]){
                dp[i][0] = true;
            }else{
                for (int j = i; j <= a1.length; j++) {
                    dp[i][0] = false;
                }
                break;
            }
        }
        for (int i = 1; i <= a2.length; i++) {
            if(a2[i - 1] == a3[i - 1]){
                dp[0][i] = true;
            }else{
                for (int j = i; j <= a2.length; j++) {
                    dp[0][i] = false;
                }
                break;
            }
        }

        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= a2.length; j++) {
                dp[i][j] = (a1[i - 1] == a3[i + j - 1] && dp[i - 1][j]) | (a2[j - 1] == a3[i + j - 1] && dp[i][j - 1]);
            }
        }

        return dp[a1.length][a2.length];
    }

}