package P91解码方法;

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 1){
            if(s.charAt(0) == '0'){
                return 0;
            }
            return 1;
        }else if(s.length() < 1){
            return 0;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        byte[] bytes = s.getBytes();
        int[] dp = new int[s.length()];
        dp[0] = 1;

        return -1;
    }
}