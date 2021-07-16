package P1877数组中最大数对和的最小值;

import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        int[] sort = new int[100001];
        for(int num : nums){
            sort[num] ++;
        }
        int index = 0;
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < sort[i]; j++) {
                nums[index++] = i;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max,nums[i] + nums[nums.length - i - 1]);
        }
        return max;
    }
}