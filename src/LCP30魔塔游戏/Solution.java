package LCP30魔塔游戏;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int magicTower(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer> list = new LinkedList<>();
        long live = 1;
        int ans = 0;
        for(int num : nums){
            if(num < 0){
                queue.add(num);
            }
            live += num;
            while (live <= 0){
                Integer poll = queue.poll();

                live -= poll;
                list.add(poll);
                ans++;
            }
        }

        for(int i : list){
            live += i;
        }
        return live > 0 ? ans : -1;
    }
}