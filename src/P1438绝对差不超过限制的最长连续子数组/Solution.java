package P1438绝对差不超过限制的最长连续子数组;

import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int l = 0;
        int r = 0;
        for (r = 0; r < nums.length; r++) {
            if(!map.containsKey(nums[r])){
                map.put(nums[r],1);
            }else{
                map.put(nums[r],map.get(nums[r])+1);
            }
            while(map.lastKey() - map.firstKey() > limit){
                int countL = map.get(nums[l]);
                if(countL == 1){
                    map.remove(nums[l]);
                }else{
                    map.put(nums[l],countL - 1);
                }
                l++;
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }
}