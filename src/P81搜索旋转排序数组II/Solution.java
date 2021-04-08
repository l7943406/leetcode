package P81搜索旋转排序数组II;

import java.util.Arrays;
/*
class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        return Arrays.binarySearch(nums,target) >= 0;
    }
}
//*/
//class Solution {
//    public boolean search(int[] nums, int target) {
//        for(int i : nums){
//            if(i == target){
//                return true;
//            }
//        }
//        return false;
//    }
//}


class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2 ;
            if(nums[mid] == target || nums[l] == target || nums[r] == target){
                return true;
            }else if(nums[mid] < target && nums[r] > target){
                l = mid + 1;
            }else if(nums[mid] > target && nums[l] < target){
                r = mid - 1;
            }else{
                l++;
                r--;
            }
        }
        return false;
    }
}