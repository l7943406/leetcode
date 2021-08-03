package P1953你可以工作的最大周数;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for(int i : milestones){
            queue.offer(i);
        }
        long ans = 0;



        while (queue.size() > 1){
            int one = queue.poll();
            int two = queue.poll();
            ans += two + two;
            if(one - two != 0) {
                queue.offer(one - two);
            }
        }

        return queue.size() == 0 ? ans : ans + 1;
    }
}
/*

5 5 7 7 7 9
 */