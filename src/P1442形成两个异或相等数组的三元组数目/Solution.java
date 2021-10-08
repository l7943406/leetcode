package P1442形成两个异或相等数组的三元组数目;

class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int xor = 0;
        for (int j : arr) {
            xor ^= j;
        }
        for (int i = 0; i < arr.length; i++) {
            int l = xor;
            int r = 0;
            for (int j = arr.length - 1; j > i; j--) {
                l ^= arr[j];
                r ^= arr[j];
                if(l == r){
                    ans ++;
                }
            }
            xor ^= arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().countTriplets(new int[]{2,3,1,6,7});
    }
}
/*
给你一个整数数组 arr 。

现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。

a 和 b 定义如下：

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
注意：^ 表示 按位异或 操作。

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */