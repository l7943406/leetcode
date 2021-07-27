package P39组合总和;

import java.util.*;

class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> ans;
    int[] queue;
    int top;
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.ans = new LinkedList<>();
        this.queue = new int[target + 1];
        this.top = 0;
        this.sum = 0;
        dfs(0);
        return ans;
    }
    void dfs(int index){
        if(sum > target){
            return;
        }else if(sum == target){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < top; i++) {
                list.add(queue[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            queue[top++] = candidate;
            sum += candidate;
            dfs(i);
            top--;
            sum -= candidate;
        }
    }
}