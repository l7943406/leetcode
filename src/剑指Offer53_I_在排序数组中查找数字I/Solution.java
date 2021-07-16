package 剑指Offer53_I_在排序数组中查找数字I;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                index = mid;
                break;
            }
        }
        if(index == -1){
            return 0;
        }
        int ans = 0;
        left = 0;
        right = index - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] >= target){
                right = mid - 1;
            }
        }
        ans = left;
        left = index + 1;
        right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return right - ans + 1;


    }
}