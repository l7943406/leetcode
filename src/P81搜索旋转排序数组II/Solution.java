package P81搜索旋转排序数组II;

import java.util.Arrays;
/*
class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        return Arrays.binarySearch(nums,target) >= 0;
    }
}
*/
class Solution {
    public boolean search(int[] nums, int target) {
        for(int i : nums){
            if(i == target){
                return true;
            }
        }
        return false;
    }
}