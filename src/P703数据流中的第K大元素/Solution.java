package P703数据流中的第K大元素;

import java.util.*;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });;
        for (int i:nums){
            queue.offer(i);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() != k){
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */