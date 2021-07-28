package P863二叉树中所有距离为K的结点;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> ans;
    TreeNode target;
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.ans = new LinkedList<>();
        this.target = target;
        this.k = k;
        solve(root);
        return ans;
    }
    public boolean solve(TreeNode root){
        if(root == null){
            return false;
        }
        if(root == target){
            find(root,k);
            return true;
        }

        if(solve(root.left)){
            k--;
            if(k == 0){
                ans.add(root.val);
                return false;
            }else if(k > 0){
                find(root.right,k - 1);
                return true;
            }
        }else if(solve(root.right)){
            k--;
            if(k == 0){
                ans.add(root.val);
                return false;
            }else if(k > 0){
                find(root.left,k - 1);
                return true;
            }
        }
        return false;
    }


    public void find(TreeNode root,int k){
        if(root == null){
            return;
        }
        if(k == 0){
            ans.add(root.val);
            return;
        }
        find(root.left,k - 1);
        find(root.right,k - 1);
    }
}