package 剑指OfferII083没有重复元素集合的全排列;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    int[] nums;
    boolean[] book;
    int[] stack;
    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList<>();
        this.nums = nums;
        this.stack = new int[nums.length];
        this.book = new boolean[nums.length];
        dfs(0);
        return ans;
    }
    private void dfs(int step){
        if(step == nums.length){
            List<Integer> list = new LinkedList<>();
            for(int i : stack){
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!book[i]){
                book[i] = true;
                stack[step] = i;
                dfs(step + 1);
                book[i] = false;
            }
        }
    }

}