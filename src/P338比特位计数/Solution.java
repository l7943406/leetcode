package P338比特位计数;

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            ans[i] = i % 2 == 0 ? ans[i / 2] : ans[i - 1] + 1;
        }
        return ans;
    }
}