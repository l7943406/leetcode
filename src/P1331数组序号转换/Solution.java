package P1331数组序号转换;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        System.arraycopy(arr, 0, ans, 0, arr.length);
        Arrays.sort(arr);

        Map<Integer,Integer> map = new HashMap<>(arr.length * 4 / 3);
        for (int j : arr) {
            map.putIfAbsent(j, map.size() + 1);
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(ans[i]);
        }

        return ans;
    }
}

/*

给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。

 */