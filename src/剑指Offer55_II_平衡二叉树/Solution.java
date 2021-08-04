package 剑指Offer55_II_平衡二叉树;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private boolean ans;
    public boolean isBalanced(TreeNode root) {
        this.ans = true;
        dfs(root,0);
        return ans;
    }
    private int dfs(TreeNode root,int floor){
        if(!ans || root == null){
            return floor;
        }

        int r = dfs(root.right,floor + 1);
        int l = dfs(root.left,floor + 1);
        if(Math.abs(l - r) > 1){
            ans = false;
            return 0;
        }
        return Math.max(l,r);
    }
}