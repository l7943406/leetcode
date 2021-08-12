package P77组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    int n;
    int k;
    boolean[] book;
    int[] stack;
    public List<List<Integer>> combine(int n, int k) {
        ans = new LinkedList<>();
        this.n = n;
        this.k = k;
        this.book = new boolean[n + 1];
        this.stack = new int[k];
        dfs(0,1);
        return ans;
    }
    private void dfs(int step,int index){
        if(step == k){
            List<Integer> list = new LinkedList<>();
            for(int s : stack){
                list.add(s);
            }
            ans.add(list);
            return;
        }
        for(int i = index; i <= n; i++){
            if(!book[i]){
                book[i] = true;
                stack[step] = i;
                dfs(step + 1,i + 1);
                book[i] = false;
            }
        }
    }
}