package P1679K和数对的最大数目;

import java.util.Arrays;


/**
 *  双指针解法
 * */
class Solution2 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l < r){
            int add = nums[l] + nums[r];
            if(add < k){
                l++;
            }else if(add > k){
                r--;
            }else{
                l++;
                r--;
                ans++;
            }
        }
        return ans;
    }
}