package P1438绝对差不超过限制的最长连续子数组;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        //顺序
        PriorityQueue<Integer> order = new PriorityQueue<>((o1, o2) -> o1 - o2);
        //逆序
        PriorityQueue<Integer> reverse = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int l = 0;
        int r = 0;
        for (r = 0; r < nums.length; r++) {
            order.offer(nums[r]);
            reverse.offer(nums[r]);
            while(reverse.peek() - order.peek() > limit){
                reverse.remove(nums[l]);
                order.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }
}