package P70爬楼梯;

class Solution {
    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2) {
            return 2;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n];
    }
}