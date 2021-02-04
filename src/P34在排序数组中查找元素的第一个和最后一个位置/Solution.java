package P34在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int l=0,r=nums.length-1;
        int t;
        int ans = -1;

        while(l<=r){
            t = (l+r)/2 ;
            if(target > nums[t]){
                l = t +1 ;
            }else if(target < nums[t]){
                r = t -1 ;
            }else{
                ans = t;
                r = t-1;
            }
        }

        result[0] = ans;


        l = 0;
        r=nums.length-1;
        t = 0;
        ans = -1;
        while(l<=r){
            t = (l+r)/2 ;
            if(target > nums[t]){
                l = t +1 ;
            }else if(target < nums[t]){
                r = t -1 ;
            }else{
                ans = t;
                l = t+1;
            }
        }
        result[1] = ans;
        return result ;
    }
}