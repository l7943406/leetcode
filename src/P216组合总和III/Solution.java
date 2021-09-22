package P216组合总和III;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    boolean[] book ;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new LinkedList<>();
        this.book = new boolean[10];
        dfs(0, k, 1, 0, n);
        return this.ans;
    }
    private void dfs(int step,int k, int start, int num, int n){
        if(step == k){
            if(num == n){
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < book.length; i++) {
                    if(book[i]){
                        list.add(i);
                    }
                }
                ans.add(list);
            }
        }
        if(num >= n){
            return;
        }


        for (int i = start; i < 10; i++) {
            if(!book[i]){
                book[i] = true;
                dfs(step + 1, k , i + 1, num + i, n);
                book[i] = false;
            }
        }

    }
}