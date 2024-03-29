package P446等差数列划分II子序列;


import java.util.Arrays;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        long[][] map = new long[nums.length - 1][];
        for (int i = 0; i < nums.length - 1; i++) {
            map[i] = new long[nums.length - i  - 1];
            for (int j = i + 1; j < nums.length; j++) {
                map[i][j - i - 1] = nums[i] - nums[j];
            }
        }
        System.out.println(Arrays.deepToString(map));

        return 0;
    }

    public static void main(String[] args) {
        new Solution().numberOfArithmeticSlices(new int[]{2,4,6,8,10});

        new Solution().numberOfArithmeticSlices(new int[]{7,7,7,7,7});

        new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4});
    }
}
/*

给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。

如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。

例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
再例如，[1, 1, 2, 5, 7] 不是等差序列。
数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。

例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
题目数据保证答案是一个 32-bit 整数。

 */