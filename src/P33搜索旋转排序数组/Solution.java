package P33搜索旋转排序数组;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2 ;
            if(nums[m] == target){
                return m;
            }
            if(nums[l] < nums[r]){
                if(nums[m] > target){
                    r = m - 1;
                }else if(nums[m] < target){
                    l = m + 1;
                }
            }else{
                if(nums[m] < nums[0]){
                    if(nums[m] < target && nums[0] > target){
                        l = m + 1;
                    }else{
                        r = m - 1;
                    }
                }else{
                    if(nums[m] > target && nums[0] <= target){
                        r = m - 1;
                    }else{
                        l = m + 1;
                    }
                }
            }
        }
        return -1;
    }

}
/*

[4,5,6,7,8,9,10,-10,-9,-8,-7,0,1,2]
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 */
/*
4
5
6
6
0
1
2
3

4
5
6
-1
0
1
2
3[4,5,6,7,0,1,2]
0
[4,5,6,7,0,1,2]
1
[4,5,6,7,0,1,2]
2
[4,5,6,7,0,1,2]
3
[4,5,6,7,0,1,2]
4
[4,5,6,7,0,1,2]
5
[4,5,6,7,0,1,2]
6
[4,5,6,7,0,1,2]
7

*/