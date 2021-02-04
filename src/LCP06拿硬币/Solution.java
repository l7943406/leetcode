package LCP06拿硬币;

class Solution {
    public int minCount(int[] coins) {
        int ans =0;
        for (int t:
             coins) {
            if(t%2 == 0){
                ans += t/2;
            }else{
                ans += (t-1)/2 + 1;
            }

        }
        return ans;
    }
}