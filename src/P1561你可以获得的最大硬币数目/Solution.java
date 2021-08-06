package P1561你可以获得的最大硬币数目;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int max = piles[0];
        int min = piles[0];
        for(int pile : piles){
            max = Math.max(max,pile);
            min = Math.min(min,pile);
        }
        int[] nums = new int[max - min + 1];
        for(int pile : piles){
            nums[pile - min] ++;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                piles[index++] = i + min;
            }
        }


        int ans = 0;
        for (int i = piles.length - 2; i >= piles.length  / 3; i -= 2) {
            ans += piles[i];
        }
        return ans;
    }
}
/*

有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：

每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
Alice 将会取走硬币数量最多的那一堆。
你将会取走硬币数量第二多的那一堆。
Bob 将会取走最后一堆。
重复这个过程，直到没有更多硬币。
给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。

返回你可以获得的最大硬币数目。
 */