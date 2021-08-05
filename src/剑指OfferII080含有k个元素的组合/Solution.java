package 剑指OfferII080含有k个元素的组合;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    boolean[] book;
    int[] stack;
    public List<List<Integer>> combine(int n,int k) {
        ans = new LinkedList<>();
        this.stack = new int[k];
        this.book = new boolean[n];
        dfs(0,0);
        return ans;
    }
    private void dfs(int step,int start){
        if(step == stack.length){
            List<Integer> list = new LinkedList<>();
            for(int i : stack){
                list.add(i + 1);
            }
            ans.add(list);
            return;
        }
        for (int i = start; i < book.length; i++) {
            if(!book[i]){
                book[i] = true;
                stack[step] = i;
                dfs(step + 1,i + 1);
                book[i] = false;
            }
        }
    }

}