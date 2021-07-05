package P15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int l = 0,r = nums.length - 1;
        while (l < r){
            r = nums.length - 1;
            if(nums[r] < 0 || nums[l] > 0){
                break;
            }

            while (l < r){
                if(nums[r] < 0 || nums[l] > 0 || - nums[l] - nums[r] > nums[r]){
                    break;
                }else{
                    if(Arrays.binarySearch(nums,l + 1,r,- nums[l] - nums[r]) >= 0){
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[l]);
                        list.add(- nums[l] - nums[r]);
                        list.add(nums[r]);
                        ans.add(list);
                    }
                    int t = r;
                    while (r >= 0 && nums[r] == nums[t]){
                        r--;
                    }
                }
            }
            int t = l;
            while (l <=nums.length - 1 && nums[l] == nums[t]){
                l++;
            }
        }


        return ans;
    }

}