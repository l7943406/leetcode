package P910最小差值II;

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int ans = max - min;
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i - 1], b = nums[i];

        }
        return 0;
    }
}