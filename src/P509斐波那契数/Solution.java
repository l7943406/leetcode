package P509斐波那契数;

class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];


    }
}
/*
斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。
该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。
也就是：

F(0) = 0，F(1)= 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。

 */