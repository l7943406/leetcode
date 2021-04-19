package P27移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        if(nums == null){
            return 0;
        }
        for(int i : nums){
            if(i != val){
                nums[index ++] = i;
            }
        }
        return index;
    }
}