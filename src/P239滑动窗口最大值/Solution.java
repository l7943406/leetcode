package P239滑动窗口最大值;


import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if(i!=0){
                queue.add(i);
            }
            ans[0] = Math.max(ans[0],nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peek() <= i-k){
                queue.poll();
            }
            if(i+1>k){

                ans[index++] = nums[queue.peek()];
            }
        }
        return ans;
    }

}
