package P354俄罗斯套娃信封问题;

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int ans = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
}