package 剑指OfferII038每日温度;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> queue = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        queue.addLast(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            while (!queue.isEmpty() && queue.peekLast()[0] < temperatures[i]){
                int[] min = queue.pollLast();
                ans[min[1]] = i - min[1];
            }
            queue.addLast(new int[]{temperatures[i], i});
        }
        for(int[] ids : queue){
            ans[ids[1]] = 0;
        }

        return ans;
    }


}
/*

请根据每日 气温 列表 temperatures，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。

 */