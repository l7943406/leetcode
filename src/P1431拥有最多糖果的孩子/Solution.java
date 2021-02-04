package P1431拥有最多糖果的孩子;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int candie : candies) {
            max = Math.max(candie , max);
        }
        for (int candie : candies) {
            if(candie + extraCandies >= max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;

    }
}