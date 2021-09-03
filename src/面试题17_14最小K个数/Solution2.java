package 面试题17_14最小K个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**堆*/
public class Solution2 {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for(int num : arr){
            if(queue.size() < k){
                queue.add(num);
            }else{
                if(queue.peek() > num){
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i : queue){
            ans[index ++] = i;
        }
        return ans;
    }
}
