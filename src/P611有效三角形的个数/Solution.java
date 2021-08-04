package P611有效三角形的个数;

import java.util.Arrays;
@SuppressWarnings("all")

class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        int[] map = new int[1001];
        for(int num : nums){
            map[num] ++;
        }
        for (int i = 1; i < map.length; i++) {
            map[i] += map[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[j] != 0){
                        int l = Math.abs(nums[i] - nums[j]);
                        int r = Math.min(1000,nums[i] + nums[j] - 1);
                        ans += map[r] - map[l];
                        if(nums[i] > l && nums[i] <= r && nums[j] > l && nums[j] <= r){
                            ans -= 2;
                        }else if(nums[i] > l && nums[i] <= r || nums[j] > l && nums[j] <= r){
                            ans--;
                        }
                    }
                }
            }
        }





        return ans / 3;
    }

}
