package P121买卖股票的最佳时机;

import org.omg.CORBA.MARSHAL;

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int ans = 0;
        for(int price : prices){
            if(price < min){
                min = price;
            }else{
                ans = Math.max(ans,price-min);
            }
        }

        return ans;

    }
}