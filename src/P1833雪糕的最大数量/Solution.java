package P1833雪糕的最大数量;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for(int i : costs){
            if(i <= coins){
                coins -= i;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}