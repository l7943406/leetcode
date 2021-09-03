package 面试题17_14最小K个数;

import java.util.Arrays;

/**排序*/
class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }
}