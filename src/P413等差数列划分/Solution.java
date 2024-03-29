package P413等差数列划分;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] -= nums[i - 1];
        }
        int lastIndex = 0;
        int lastNum = 6000;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != lastNum){
                if(i - lastIndex > 1){
                    ans += getNum(i - lastIndex + 1);
                }
                lastIndex = i;
                lastNum = nums[i];
            }
        }
        if(nums.length - lastIndex > 1){
            ans += getNum(nums.length - lastIndex + 1);
        }
        return ans;
    }
    private int getNum(int n){
        return (n * n - 3 * n + 2) / 2;
    }
}
/*

如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

子数组 是数组中的一个连续序列。

 */