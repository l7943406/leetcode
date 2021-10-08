package 剑指OfferII100三角形中最小路径之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> list1 = triangle.get(triangle.size() - 1);
        for (int i = 0; i < list1.size(); i++) {
            dp[i] = list1.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

}
