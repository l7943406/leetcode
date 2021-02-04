package P724寻找数组的中心索引;

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int l = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if(l == sum - l - nums[i]){
                return i;
            }else{
                l += nums[i];
            }
        }
        return -1;
    }
}