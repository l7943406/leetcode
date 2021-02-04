package 剑指Offer17打印从1到最大的n位数;

class Solution {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10,n);

        int[] ans = new int[end - 1];
        for (int i = 1; i < end; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}