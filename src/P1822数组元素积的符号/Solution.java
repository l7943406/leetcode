package P1822数组元素积的符号;

class Solution {
    public int arraySign(int[] nums) {

        int f = 0;
        for(int num : nums){
            if(num < 0){
                f++;
            }else if(num == 0){
                return 0;
            }
        }
        if(f % 2 == 0){
            return 1;
        }else{
            return -1;
        }
    }
}
/*

已知函数signFunc(x) 将会根据 x 的正负返回特定值：

如果 x 是正数，返回 1 。
如果 x 是负数，返回 -1 。
如果 x 是等于 0 ，返回 0 。
给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。

返回 signFunc(product) 。

 */