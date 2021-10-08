package P713乘积小于K的子数组;

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int ans = 0;
        int l = 0;
        int mutex = 1;
        for (int r = 0; r < nums.length; r++) {
            mutex *= nums[r];
            while (mutex >= k){
                mutex /= nums[l++];
            }
            ans += r - l + 1;
        }

        return ans;
    }

}