package P1046最后一块石头的重量;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i : stones){
            queue.offer(i);
        }
        while(queue.size()>=2){
            int big = queue.poll();
            int small = queue.poll();
            if(big>small){
                queue.offer(big - small);
            }
        }

        if(queue.isEmpty()){
            return 0;
        }
        return queue.poll();
    }
}