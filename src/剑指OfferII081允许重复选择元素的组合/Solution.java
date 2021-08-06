package 剑指OfferII081允许重复选择元素的组合;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("all")


class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> ans;
    int[] stack;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.stack = new int[target / candidates[0] + 1];
        this.ans = new LinkedList<>();
        dfs(0,0,0);
        return ans;
    }
    private void dfs(int step,int sum,int index){
        if(sum >= target){
            if(sum == target){
                List<Integer> list = new LinkedList<>();
                for(int i = 0; i < step; i++){
                    list.add(stack[i]);
                }
                ans.add(list);
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            stack[step] = candidates[i];
            dfs(step + 1, sum + candidates[i],i);
        }
    }
}

/*

给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。

candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

对于给定的输入，保证和为target 的唯一组合数少于 150 个。

 */