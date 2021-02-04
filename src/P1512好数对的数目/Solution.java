package P1512好数对的数目;

import java.util.Arrays;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int t=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                ans += t;
                t++;
            }else{
                t=1;
            }
        }
        return ans;
    }
}