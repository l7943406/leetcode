package P46全排列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] book;
    int[] map;
    int length;
    List<List<Integer>> ans;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        book = new boolean[nums.length];
        map = new int[nums.length];
        length = nums.length;
        ans = new ArrayList<>();
        this.nums = nums;
        dfs(0);
        return ans;
    }
    void dfs(int n){
        if(n == length){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(nums[map[i]]);
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!book[i]){
                book[i] = true;
                map[n] = i;
                dfs(n+1);
                book[i] = false;
            }
        }
    }

}