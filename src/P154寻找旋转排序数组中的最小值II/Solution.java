package P154寻找旋转排序数组中的最小值II;

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[r] > nums[mid]){
                r = mid;
            }else if(nums[r] < nums[mid]){
                l = mid + 1;
            }else{
                r--;
            }
        }
        return nums[r];
    }
}