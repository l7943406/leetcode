package P283移动零;

class Solution {
    public void moveZeroes(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                r=findNextNotZero(nums,Math.max(r,i));
                if(r == -1){
                    return;
                }else{
                    nums[i] = nums[r];
                    nums[r] = 0;
                }
            }
        }
    }

    public int findNextNotZero(int[] nums,int now){
        for (int i = now + 1; i < nums.length; i++) {
            if(nums[i] != 0){
                return i;
            }
        }
        return -1;
    }
}