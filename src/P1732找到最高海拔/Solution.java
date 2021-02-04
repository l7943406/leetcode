package P1732找到最高海拔;

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int now = 0;
        for (int i = 0; i < gain.length; i++) {
            now += gain[i];
            ans = Math.max(ans,now);
        }
        return ans;
    }
}