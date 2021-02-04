package P1551使数组中所有元素相等的最小操作数;

class Solution {
    public int minOperations(int n) {
       /* int ans = 0;
        for (int i = 0; i < n/2; i++) {
            ans +=  n - 2*i - 1;
        }
        return ans;*/
        return -1 * (n/2) - (n/2)*(n/2 - 1) + n * (n/2);
    }
}