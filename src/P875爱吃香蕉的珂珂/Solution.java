package P875爱吃香蕉的珂珂;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile,max);
        }
        if(h <= piles.length){
            return max;
        }

        while (min < max){
            int mid = (max + min) / 2;
            int time = getTime(piles,mid);
            if(time > h){
                min = mid + 1;
            }else{
                max = mid;
            }
        }


        return max;
    }
    private int getTime(int[] piles,int v){
        int ans = 0;
        for(int pile : piles){
            ans += (pile + v - 1) / v;
        }
        return ans;
    }
}
/*

珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。

珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

*/