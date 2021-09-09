package 面试题17_16按摩师;

class Solution {
    public int massage(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        nums[2] += nums[0];
        int max = Math.max(nums[1],nums[2]);
        for (int i = 3; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 2],nums[i - 3]);
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
/*
一个有名的按摩师会收到源源不断的预约请求,每个预约都可以选择接或不接
在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 */