package P456132模式;

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int[] left = new int[nums.length];
        int leftNum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < leftNum){
                leftNum = nums[i];
            }

            left[i + 1] = leftNum;

        }
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > left[i] && nums[i] - left[i] > 1){
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[j] < nums[i] && nums[j] > left[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}