package P894所有可能的满二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<TreeNode> ans;
    TreeNode root;
    Deque<TreeNode> list = new LinkedList<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if((n & 1) == 0){
            return new LinkedList<>();
        }
        ans = new LinkedList<>();
        root = new TreeNode(0,null,null);
        list.add(root);
        dfs( n - 1);
        return ans;
    }
    private void dfs(int n){
        if(n == 0){
            ans.add(copy(root));
            return;
        }
        while (!list.isEmpty()){
            TreeNode now = list.pop();
            now.left = new TreeNode(0,null,null);
            now.right = new TreeNode(0,null,null);
            list.add(now.left);
            list.add(now.right);

            dfs(n - 2);


            now.left = null;
            now.right = null;
            list.pop();
            list.pop();
        }

    }
    private TreeNode copy(TreeNode src){
        if(src == null){
            return null;
        }
        TreeNode node = new TreeNode(0);
        node.left = copy(src.left);
        node.right = copy(src.right);
        return node;

    }
}
/*
[[0]]
[]
[[0,0,0]]
[]
[[0,0,0,null,null,0,0],[0,0,0,0,0]]
[]
[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,0,0,null,null,0,0],[0,0,0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0,null,null,0,0],[0,0,0,0,0,null,null,null,null,0,0,0,0],[0,0,0,0,0,null,null,0,0,0,0],[0,0,0,0,0,null,null,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0,null,null,0,0]]
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0,0,0,0,0],[0,0,0,null,null,0,0,0,0,null,null,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0,null,null,null,null,0,0,0,0],[0,0,0,null,null,0,0,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,0,0,null,null,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,0,0,null,null,0,0,null,null,0,0],[0,0,0,0,0,0,0,null,null,null,null,null,null,0,0,null,null,0,0],[0,0,0,0,0,0,0,null,null,null,null,null,null,0,0,0,0],[0,0,0,0,0,0,0,null,null,null,null,0,0,0,0],[0,0,0,0,0,0,0,null,null,null,null,0,0,null,null,null,null,0,0],[0,0,0,0,0,0,0,nu...
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0,0,0,null,null,null,nul...
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null...
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null...
[]
[[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,null,null,0,0],[0,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,0,0,0,0,0,0],[0,0,0,null,null,0,...
[]
 */