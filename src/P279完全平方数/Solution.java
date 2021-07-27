package P279完全平方数;

import java.util.HashMap;

class Solution {
    public int numSquares(int n) {
        int[] map = new int[100];
        for (int i = 1; i <= 100; i++) {
            map[i - 1] = i * i;
        }

        int max = (int)Math.sqrt(n);
        boolean[][] dp = new boolean[4][n + 1];
        for (int i = 0; i < dp[0].length; i++) {
            double num = Math.sqrt(i);
            if (num == (int) num) {
                dp[0][i] = true;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i][n]){
                return i + 1;
            }
            for (int j = 0; j < dp[i].length; j++) {
                if(dp[i][j]){
                    for (int k = 0; k < max; k++) {
                        if(j + map[k] < n + 1){
                            dp[i + 1][j + map[k]] = true;
                            if(dp[i + 1][n]){
                                return i + 2;
                            }
                        }
                    }
                }
            }

        }

        return n;
    }
}
/*

给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */