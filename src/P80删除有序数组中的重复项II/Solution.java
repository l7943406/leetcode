package P80删除有序数组中的重复项II;

class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = 1;
            int i;
            for (i = right + 1; i < nums.length; i++) {
                if(nums[i] != nums[right]){
                    break;
                }
                num++;
            }
            nums[left++] = nums[right];
            if(num >= 2){
                nums[left++] = nums[right];
            }
            right = i - 1;
        }
        return left;
    }
}