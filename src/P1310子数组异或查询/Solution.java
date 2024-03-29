package P1310子数组异或查询;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = arr[queries[i][1]] ^ (queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1]);
        }
        return ans;
    }
}