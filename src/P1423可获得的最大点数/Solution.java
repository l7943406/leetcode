package P1423可获得的最大点数;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < k; i++) {
            num += cardPoints[i];
        }
        ans = num;
        for (int i = 0; i < k; i++) {
            num -= cardPoints[k - 1 - i];
            num += cardPoints[cardPoints.length - i - 1];
            ans = Math.max(num , ans);
        }
        return ans;
    }
}