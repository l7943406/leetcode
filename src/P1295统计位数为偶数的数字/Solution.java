package P1295统计位数为偶数的数字;

class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int t = num;
            if (t == 0) {
                continue;
            }

            boolean is = true;
            while (t != 0) {
                is = !is;
                t /= 10;
            }
            if (is) {
                ans++;
            }
        }
        return ans ;
    }
}