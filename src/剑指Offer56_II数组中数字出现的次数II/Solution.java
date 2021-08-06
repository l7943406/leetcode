package 剑指Offer56_II数组中数字出现的次数II;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] b = new int[200];
    public int singleNumber(int[] nums) {
        for(int num : nums){
            add(num);
        }
        int ans = 0;
        for (int i = 0; i < b.length; i++) {
            ans *= 2;
            ans += b[i] % 3;
        }

        return ans;
    }
    private void add(int n){
        int index = b.length - 1;
        while (n != 0){
            if((n & 1) == 1){
                b[index] ++;
            }
            index --;
            n >>= 1;
        }
    }
}
/*
    在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    1 1 1 2 2 2 3
    12
 */