package P523连续的子数组和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i] % k;
            if(map.containsKey(t)){
                if(i - map.get(t) > 2){

                    return true;
                }
            }else{
                map.put(t,i);
            }
        }
        return false;
    }
}