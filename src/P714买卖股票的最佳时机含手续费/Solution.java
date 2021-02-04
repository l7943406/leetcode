package P714买卖股票的最佳时机含手续费;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        int left = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < left){
                left = prices[i];
            }
            else if(prices[i] - left > fee){
                ans = ans + prices[i] -left - fee;
                left = prices[i] - fee;
            }
        }
        return ans;
    }
}