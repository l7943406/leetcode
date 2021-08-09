package P1137第N个泰波那契数;

class Solution {
    public int tribonacci(int n) {
        int[] a = new int[]{0, 1, 1, 0};
        if (n < 3) {
            return a[n];
        }
        n -= 2;
        while (n-- > 0) {
            a[3] = a[0] + a[1] + a[2];
            a[0] = a[1];
            a[1] = a[2];
            a[2] = a[3];
        }
        return a[3];
    }
}
/*

泰波那契序列Tn定义如下：

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数n，请返回第 n 个泰波那契数Tn 的值。

 */