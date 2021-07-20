package P1877数组中最大数对和的最小值;

import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] sort = new int[max + 1];
        for(int num : nums){
            sort[num] ++;
        }
        int index = 0;
        for (int i = 0; i < sort.length; i++) {
            if(sort[i] != 0) {
                for (int j = 0; j < sort[i]; j++) {
                    nums[index++] = i;
                }
            }
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max,nums[i] + nums[nums.length - i - 1]);
        }
        return max;
    }
}