package P91解码方法;

class Solution {
    public int numDecodings(String s) {
        byte[] bytes = s.getBytes();
        int[] dp = new int[bytes.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= bytes.length; i++) {
            if(bytes[i - 1] != '0'){
                dp[i] += dp[i - 1];
            }
            if(i > 1 && bytes[i-2]!='0' && (bytes[i - 2] - '0') * 10 + bytes[i - 1] - '0' <= 26){
                dp[i] += dp[i - 2];
            }
        }

        return dp[bytes.length];
    }
}