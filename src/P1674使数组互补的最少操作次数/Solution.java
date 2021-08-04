package P1674使数组互补的最少操作次数;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int min = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.min(min,Math.max(nums[i],nums[nums.length - i - 1]) + limit);
            int t = nums[i] + nums[nums.length - i - 1];
            map.put(t,map.getOrDefault(t, 0) + 1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getKey() >= min){
                break;
            }
            max = Math.max(max,entry.getValue());
        }
        return nums.length / 2 - max;
    }

    public static void main(String[] args) {
        new Solution().minMoves(new int[]{1,2,4,3},4);
    }
}
/*
[1,2,4,3]
4
[1,2,2,1]
2
[1,2,1,2]
2
 */