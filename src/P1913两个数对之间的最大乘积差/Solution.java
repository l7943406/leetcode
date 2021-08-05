package P1913两个数对之间的最大乘积差;

import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num >= max){
                sMax = max;
                max = num;
            }else if(num > sMax){
                sMax = num;
            }

            if(num <= min){
                sMin = min;
                min = num;
            }else if(num < sMin){
                sMin = num;
            }
        }
        return max * sMax - min * sMin;
    }
}
/*

两个数对(a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。

例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。

返回以这种方式取得的乘积差中的 最大值 。

 */