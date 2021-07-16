package 面试题_08_07_无重复字符串的排列组合;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<String> ans;
    int[] nums;
    boolean[] book;
    byte[] s;
    public String[] permutation(String S) {
        this.ans = new LinkedList<>();
        this.nums = new int[S.length()];
        this.book = new boolean[S.length()];
        this.s = S.getBytes();
        dfs(0);
        return ans.toArray(new String[0]);
    }
    public void dfs(int step){
        if(step == book.length){
            byte[] bs = new byte[step];
            for (int i = 0; i < step; i++) {
                bs[i] = s[nums[i]];
            }
            ans.add(new String(bs));
            return;
        }
        for (int i = 0; i < book.length; i++) {
            if(!book[i]){
                book[i] = true;
                nums[step] = i;
                dfs(step + 1);
                book[i] = false;
            }
        }
    }
}