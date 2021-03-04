package P354俄罗斯套娃信封问题;

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int ans = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}